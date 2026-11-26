import streamlit as st

# st.title("구매 금액 계산")
# name = st.text_input("이름")
# quantity = st.number_input("수량", min_value=1, max_value=100, value=1)
# # 아래와 같이 형변환을 해주는것이 좋다.
# total = int(quantity) * 8000
# st.metric("총액", f"{total:,}원")
# if st.button("인사"):
#     st.write(f"안녕하세요, {name.strip() or '학습자'}님")

#테스트
a = st.number_input("단가", min_value=1, max_value=100000, value=1)
b = st.number_input("수량", min_value=1, max_value=100000, value=1)

#al = st.text_input("단가")
# bl = st.text_input("수량")

# cl = int(al)*int(bl)
c = int(a*b)
d = a+b
e = a-b
f = a/b
g = a%b
if st.button("계산"):
    st.metric("총액", f"{c:,}원")

if st.button("계산기"):
    st.metric("더하기", f"{d:,}")
    st.metric("빼기", f"{e:,}")
    st.metric("곱하기", f"{c:,}")
    st.metric("나누기", f"{f}")
    st.metric("나머지", f"{g}")

# st.metric("총액", f"{cl:,}원")

