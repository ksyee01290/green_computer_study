import pandas as pd
import streamlit as st

from common import parse_sales, summarize
from pathlib import Path

st.set_page_config(page_title="미니 POS & 매출 대시보드", layout="wide")
st.title("🏪올인원 미니 POS & 매출 분석기")
st.write("**학습 목표**: 입력(`form`), 상태 유지(`session_state`), 캐싱(`cache_data`), 데이터 시각화를 하나로 통합합니다.")


#2.3 데코레이터
@st.cache_data(ttl=60)
def get_cached_summary(rows):
    return summarize(rows)

# ===========================================사이드바====================================================================

st.sidebar.header("⚙️ 데이터 관리")
if "pos_order" not in st.session_state:
    st.session_state.pos_order = []

uploaded = st.sidebar.file_uploader("추가 매출 CSV 업로드 (UTF-8)", type=["csv"])
sample_path = Path(__file__).resolve().parents[1] / "data" / "sales.csv"
raw = uploaded.getvalue() if uploaded is not None else sample_path.read_bytes()

if uploaded is not None:
    nomal = [
            {"product": "book", "quantity": 2, "price": 12000}, 
            {"product": "pen", "quantity": 5, "price": 1500}
        ]
    st.info("표시할 데이터가 없음 기본값을 표현합니다.")
    st.sidebar.dataframe(nomal)

else:
    try:
        base_rows = parse_sales(raw)
        posorder = st.session_state.pos_order
        all_rows = base_rows + posorder
        
        st.sidebar.dataframe(all_rows)
        st.sidebar.success(f"CSV에서 {len(base_rows)}행을 불러왔습니다.")
    except ValueError as exc:
        st.error(str(exc))
        st.stop()

print(type(base_rows))
print(type(posorder))
#+ st.session_state.pos_orders

#3.3 캐시초기화
if st.sidebar.button("함수 캐시 지우기"):
    get_cached_summary.clear()
    st.sidebar.success("캐시를 초기화했습니다.")
if st.sidebar.button("POS 입력 내역 초기화"):
    st.session_state.pos_order = []
    st.sidebar.warning("현장 주문 내역이 초기화되었습니다.")




#============================================메인 페이지=========================================================================

tab1,tab2,tab3 = st.tabs(["📊 매출 대시보드","💳 POS 주문 입력","💬 매출 도우미 챗봇"])

with tab1:
    st.subheader("매출 대시보드")
    choices = ["전체"] + sorted({row["product"] for row in all_rows})
    selected = st.selectbox("상품", choices)
    filtered = all_rows if selected == "전체" else[
        row for row in all_rows if row["product"] == selected
    ]
    summary = get_cached_summary(filtered)

    col1, col2, col3 = st.columns(3)
    with col1:
        st.metric("총매출", f"{summary['revenue']:,}원")
    with col2:
        st.metric("총 판매 수량", f"{summary['quantity']:,}개")
    with col3:
        st.metric("거래 건수", f"{len(filtered)}건")

    left, right = st.columns([1.2,1])
    with left:
        st.subheader("상세 거래 내역")
        if filtered:
            df = pd.DataFrame(filtered)
            df["subtotal"] = df["quantity"] * df["price"]
            st.dataframe(df, use_container_width=True, hide_index=True)
        else:
            st.info("표시할 데이터가 없습니다.")
    with right:
        st.subheader("상품별 매출 비중")
        if summary["by_product"]:
            st.bar_chart(summary["by_product"])

with tab2:
    st.subheader("신규 현장 주문 등록")
    with st.form("pos_form", clear_on_submit=True):
        p_name = st.text_input("상품명 (1~40자)")
        c1, c2 = st.columns(2)
        with c1:
            p_qty = c1.number_input("수량",min_value=1, max_value=1000, value=1)
        with c2:
            p_price = c2.number_input("단가 (원)", min_value=100, max_value=1_000_000, value=5000, step=500)
        submitted = st.form_submit_button("주문 추가")
    if submitted:
        clean_name = p_name.strip()
        if not clean_name or len(clean_name) > 40:
            st.error("상품명은 공백 제외 1~40글자로 입력하세요.")
        else:
            posorder.append({"product": clean_name, "quantity": int(p_qty), "price":int(p_price)})
            st.success(f"'{clean_name}' {p_qty}개 (총{p_qty * p_price:,}원) 주문이 등록되었습니다! 대시보드 탭에서 확인하세요.")


with tab3:
    st.subheader("데이터 기반 간단 Q&A")
    total_summary = get_cached_summary(all_rows)
    best = max(total_summary["by_product"].items(), key=lambda x: x[1])
    answer = {
        ("총매출","매출"):
            f"현재 누적 총맴출은 **{total_summary['revenue']:,}원**입니다.",
        ("인기","가장","상품"):
            f"매출 1위 상품은**{best[0]}**이며, 총 **{best[1]:,}원**의 매출을 기록했습니다.",
        ("수량","건수"):
            f"총 거래 건수는 **{len(all_rows)}건**, 총판매 수량은 **{total_summary['quantity']:,}개**입니다."
    }

    #2.1 빈리스트 초기화
    if "messages" not in st.session_state:
        st.session_state.messages = []
        st.session_state.messages.append({
                "role": "assistant", "content": "안녕하세요! '총매출', '인기상품', '주문건수' 등을 물어보세요."
            })
        
    if st.button("대화 지우기"):
        st.session_state.messages = []

    question = st.chat_input("질문")
    if question:
        reply = "질문을 이해하지 못했습니다. **'총매출'**, **'인기 상품'**, **'판매 수량'** 키워드를 포함해 질문해 주세요!"
        for keywords in answer:
            for keyword in keywords:
                if keyword in question:
                    if keyword in ("총매출","매출"):
                        if total_summary["revenue"] > 0:
                            reply = answer[keywords]
                        else:
                            reply = "매출 데이터가 없습니다."
                    elif keyword in ("인기","가장","상품"):
                        if total_summary['by_product']:
                            reply = answer[keywords]
                        else:
                            reply = "매출 데이터가 없습니다."
                    elif keyword in ("수량","건수"):
                        if total_summary['quantity']:
                            reply = answer[keywords]
                        else:
                            reply = "수량 데이터가 없습니다."                        
                    break
        st.session_state.messages.append({"role": "user", "content": question})
        st.session_state.messages.append({"role": "assistant", "content": reply})
    #2 출력부분
    for message in st.session_state.messages:
        with st.chat_message(message["role"]):
            st.write(message["content"])
