# .strip() 여기서 .은 이전작업을 모두마친뒤 다음작업을 이어서하라는 소리
name = input("이름: ").strip()
raw_quantity = input("수량: ")
# int(),float() 이런식으로 문자열을 형변환하여 사용할수있다.
quantity = int(raw_quantity)
total = quantity * 8000
# :, 이건 1000단위로 ,표시를 해주겠다는 소리
print(f"{name}님, 총액: {total:,}원")
print("book,pen".split(","))

#테스트
a = input("상품: ").strip()
b = input("수량: ")
c = int(b)
print(f"상품: {a}/ 수량:{c:,}")
