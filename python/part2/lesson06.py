import streamlit as st

#예제1,2 테스트
st.title("세션 카운터")
if "count" not in st.session_state:
    st.session_state.count = 0
if st.button("증가"):
    st.session_state.count += 10
if st.button("초기화"):
    st.session_state.count = 0
if st.button("감소"):
    if st.session_state.count !=0:
        st.session_state.count -= 5

st.metric("현재 값", st.session_state.count)

#예제 3
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