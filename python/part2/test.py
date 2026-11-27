import time
import pandas as pd
import streamlit as st

from common import parse_sales, summarize
from pathlib import Path

st.title("FAQ 도우미")
answers = {"환불": "반품 신청은 수령 후 7일 이내입니다.",
           "배송": "배송 준비는 영업일 기준 2일 입니다."}

if "chat" not in st.session_state:
    st.session_state.chat=[]
question = st.chat_input("궁금한 점을 입력하세요")
if question and question.strip():
    reply = "등록된 답변이 없습니다."
    for keyword, answer in answers.items():
        if keyword in question:
            reply = answer
            break
    st.session_state.chat.append({"role": "user", "content": question})
    st.session_state.chat.append({"role": "assistant", "content": reply})
for message in st.session_state.chat:
    with st.chat_message(message["role"]):
        st.write(message["content"])