import streamlit as st

#예제1.1
if "messages" not in st.session_state:
    st.session_state.messages = []
question = st.chat_input("질문")
if question:
    st.session_state.messages.append({
        "role": "user", "content": question
    })
for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.write(message["content"])

#예제1
if "messages" not in st.session_state:
    st.session_state.messages = []
if st.button("대화 지우기"):
    st.session_state.messages = []

for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.write(message["content"])

question = st.chat_input("질문")
if question and question.strip():
    answer = f"연습응답: {question.strip()}"
    for role, content in [("user", question),("assistant", answer)]:
        st.session_state.messages.append({"role":role, "content": content})
        with st.chat_message(role):
            st.write(content)

#예제2
if "messages" not in st.session_state:
    st.session_state.messages = []
question = st.chat_input("질문")
if question and question.strip():
    st.session_state.messages +=[
        {"role": "user", "content": question},
        {"role": "assistant", "content": f"길이: {len(question)}"}
    ]
    st.session_state.messages = st.session_state.messages[-10:]

for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.write(message["content"])

#예제3
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



#테스트 1 사용자와 응답 영할 유지 2 질문길이 출력 3 메시지수 최대10 4 초기화기능유지
if "messages" not in st.session_state:
    st.session_state.messages = []

if st.button("대화 지우기"):
    st.session_state.messages = []

for message in st.session_state.messages:
    with st.chat_message(message["role"]):
        st.write(message["content"])

question = st.chat_input("질문")
if question and question.strip():
    answer = f"질문 길이: {len(question.strip())}"
    for role, content in [("user", question),("assistant", answer)]:
        st.session_state.messages.append({"role":role, "content": content})
        with st.chat_message(role):
            st.write(content)
