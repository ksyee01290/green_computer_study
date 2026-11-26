import streamlit as st
import pandas as pd
#pandas는 통계쪽에서 많이사용한다.

st.title("상품별 매출")
rows = [
    {"product": "book", "quantity": 2, "price": 12000},
    {"product": "pen", "quantity": 5, "price": 1500}
]

df = pd.DataFrame(rows)
df["revenue"] = df["quantity"] * df["price"]
# hide_index = pandas에서 제공해주는 행번호를 True 로 숨길수있다
# 기본값은 False

# dataframe = pandas에서 제공해주는 표를 웹에서 표현해주는 함수
st.dataframe(df, hide_index=True)
# bar_chart = pandas에서 제공해주는 챠트를 웹에서 표현해주는 함수
st.bar_chart(df.set_index("product")["revenue"])
st.metric("총매출", f"{int(df['revenue'].sum()):,}원")

#테스트
rows = [
    {"subject": "국어", "score": 90},
    {"subject": "영어", "score": 80},
    {"subject": "수학", "score": 100}
]
df = pd.DataFrame(rows)
st.dataframe(df, hide_index=True)
st.bar_chart(df.set_index("subject"))
st.metric("평균",f"{int(df["score"].sum()/3):.1f}점")