import time
from pathlib import Path
import pandas as pd
import streamlit as st

st.title("할 일 목록")
if "todos" not in st.session_state:
    st.session_state.todos = []
new = st.text_input("할일")
if st.button("추가") and new.strip():
    st.session_state.todos.append(new.strip())
if st.button("모두 지우기"):
    st.session_state.todos = []
for number, todo in enumerate(st.session_state.todos, 1):
    st.write(f"{number}.{todo}")
st.caption(f"총 {len(st.session_state.todos)}개")