import streamlit as st

# st.set_page_config(page_title="학습 안내", layout="wide")
# st.title("개발자반")
# st.markdown("**오늘 목표**: 입력과 결과를 구분합니다.")
# st.sidebar.header("학습 안내")
# st.sidebar.write("총60시간")
# left, right = st.columns(2)
# with left:
#     st.header("입력")
#     st.write("왼쪽에서 조건을 고릅니다.")
# with right:
#     left, right = st.columns(2)
#     with left:
#         st.header("왼쪽")
#     with right:
#         st.header("오른쪽")
#     st.header("결과")
#     st.write("오른쪽에서 결과를 확인합니다.")

# #예제2
# st.title("온라인 문구점")
# left, right = st.columns(2)
# with left:
#     st.header("노트")
#     st.markdown("**학습 기록용** 노트")
# with right:
#     st.header("가격")
#     st.write("8000원")
# st.sidebar.write("설명을 읽고 상품을 선택")

# #예제3
# st.set_page_config(page_title="과정 소개", layout="wide")



#테스트
st.set_page_config(page_title="학습 안내", layout="wide")
st.title("상품소개")
st.markdown("스위치2")

st.sidebar.header("사용법")
st.sidebar.write("전원을켜고 게임칩을 넣습니다.")

left, right = st.columns(2)
with left:
    st.header("상품 설명")
    st.write("스위치2는 현재 재고가없을정도로 잘나갑니다")
with right:
    st.header("가격 안내")
    st.write("가격은 약 70~80만원대로 형성되어있습니다.")