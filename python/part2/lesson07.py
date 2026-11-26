import streamlit as st

#예제 1
st.title("주문 미리보기")
with st.form("order_form"):
    name = st.text_input("이름")
    raw = st.text_input("수량",value="1")
    submitted = st.form_submit_button("계산")

if submitted:
    st.session_state.pop("result",None)
    try:
        quantity = int(raw)
        if not name.strip() or not 1 <= quantity <= 100:
            raise ValueError("이름과 1~100의 수량을 입력하세요.")
        st.session_state.result = quantity * 8000
        st.metric("값",f"{st.session_state.result:,}원")
    except ValueError:
        st.error("이름과 1~100의 정수 수량을 확인하세요")
if "result" in st.session_state:
    st.metric("총액",f"{st.session_state.result:,}원")

#예제2
st.caption("이메일 형식 검증을 단순화한 미리보기")
with st.form("apply"):
    email = st.text_input("이메일")
    people = st.number_input("인원",min_value=1, max_value=10)
    done = st.form_submit_button("미리보기")
if done:
    if "@" not in email:
        st.error("이메일을 확인하세요.")
    else:
        st.write(email, int(people))

#예제3
st.title("수강 신청")
with st.form("signup"):
    name = st.text_input("이름")
    email = st.text_input("이메일")
    hours = st.number_input("주당 학습 시간", min_value=0, max_value=40, value=5)
    submitted = st.form_submit_button("신청")
if submitted:
    errors = []
    if not name.strip():
        errors.append("이름을 입력하세요.")
    if "@" not in email:
        errors.append("이메일 형식을 확인하세요.")
    if hours < 2:
        errors.append("주당 2시간 이상이 필요합니다.")
    if errors:
        for message in errors:
            st.error(message)
    else:
        st.success(f"{name.strip()}님, 신청이 접수되었습니다.")



#테스트
import streamlit as st

st.title("주문 미리보기")
with st.form("order_form"):
    name = st.text_input("이메일")
    raw = st.number_input("인원",min_value=1,max_value=100, value=1)
    submitted = st.form_submit_button("신청")

if submitted:
    st.session_state.pop("result",None)
    try:
        quantity = int(raw)
        if name not in "@" :
            st.error("@ 부재입니다.")
        if not 1 <= quantity <= 10:
            st.error("인원 1~10의 수량을 입력하세요.")
        st.session_state.result = quantity
    except ValueError:
        st.error("dlfm")

if "result" in st.session_state:
    st.metric("이메일",name)
    st.metric("인원",raw)
