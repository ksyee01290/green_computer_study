import streamlit as st

#예제1
st.title("계산 결과 재사용")
@st.cache_data(ttl=30)
def sum_squares(limit):
    return sum(n*n for n in range(limit+1))

limit = st.number_input("끝 숫자", min_value=1, max_value=10000, value=3)
with st.spinner("계산 중"):
    result = sum_squares(int(limit))

st.metric("제곱합", result)
if st.button("함수 캐시 지우기"):
    sum_squares.clear()
    st.success("캐시를 지웠습니다.")

#예제2
@st.cache_data(ttl=3)
def total(n):
    return sum(range(1,n+1))
n = st.number_input("n",min_value=1, value=10)
with st.spinner("계산중"):
    result = total(int(n))
st.write(result)

#예제3
import time
from pathlib import Path
import pandas as pd
import streamlit as st

st.title("캐시로 읽기 속도 비교")
csv_path = Path(__file__).resolve().parents[2] / "python" / "data" / "sales.csv"

@st.cache_data
def load(path):
    time.sleep(1)
    return pd.read_csv(path)

start = time.perf_counter()
df = load(str(csv_path))
elapsed = time.perf_counter() - start
st.dataframe(df, hide_index=True)
st.write(f"읽기 시간: {elapsed:.2f}초")

if st.button("캐시 지우기"):
    load.clear()
    st.info("다음 실행에서 파일을 다시 읽습니다.")

    

#테스트
st.title("계산 결과 재사용")
@st.cache_data(ttl=3)
def sum_squares(Limit):
    return sum(range(limit+1))

limit = st.number_input("끝 숫자",min_value=1, max_value=100, value=1)
with st.spinner("계산 중"):
    result = sum_squares(int(limit))
st.metric("제곱합", result)

if st.button("이 함수 캐시 지우기"):
    sum_squares.clear()
    st.success("캐시를 지웠습니다.")

#추가
import streamlit as st

tab1,tab2,tab3 = st.tabs(["aaaaaaaa","bbbbbb","ccccccc"])

with tab1:
    st.subheader("신규")
with tab2:
    st.subheader("신규2")
with tab3:
    st.subheader("신규3")