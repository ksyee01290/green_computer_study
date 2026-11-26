import streamlit as st
import pandas as pd
from common import parse_sales


st.title("CSV 업로드")
uploaded = st.file_uploader("매출 CSV", type=["csv"])

if uploaded is None:
    st.info("data/sales.csv 를 선택하세요.")
else:
    try:
        rows = parse_sales(uploaded.getvalue())
        st.dataframe(rows)

        df = pd.DataFrame(rows)
        st.bar_chart(df.set_index("product"))
        
        st.success(f"{len(rows)}행을 읽었습니다.")
    except ValueError as exc:
        st.error(str(exc))


#테스트
import streamlit as st
from com import parse_s
st.set_page_config(page_title="csv", layout="wide")

st.title("CSV 업로드")
uploaded = st.file_uploader("매출 CSV", type=["csv"])

st.sidebar.header("설명서")
st.sidebar.write("필수 열 순서: product,quantity,price")

if uploaded is None:
    st.info("업로드 가 없음 csv를 선택하세요.")
    
else:
    try:
        rows = parse_s(uploaded.getvalue())
        st.dataframe(rows)

        st.success(f"{len(rows)}행을 읽었습니다.")
    except ValueError as exc:
        st.error(str(exc))