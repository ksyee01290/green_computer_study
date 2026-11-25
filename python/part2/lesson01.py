import streamlit as st

st.set_page_config(page_title="첫 앱", layout="centered")
st.title("나의 첫 Streamlit 앱")
st.write("파이썬으로 만든 웹 화면 입니다.")
st.write("계산 결과: ", 8000 * 3)

st.title("나의 학습 목표")
st.write("파이썬 문법을 익힙니다.")
st.write("문서를 찾는 ai 앱을 만듭니다.")

st.title("오늘의 계산")
price = 12000
quantity = 3
st.write("단가: ", price)
st.write("수량: ", quantity)
st.write("합계: ", price * quantity)