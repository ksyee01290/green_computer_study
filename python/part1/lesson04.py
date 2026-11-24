total = 30000
is_member = False
if total < 0:
    message = "금액 오류"
elif total >= 30000 and is_member:
    message = "무료 배송"
else:
    message =  "배송비 3000원"

print(message)

age = 15
has_ticket = True
if age < 0:
    message = "나이 오류"
elif age >= 19 and has_ticket:
    message = "입장 가능"
elif has_ticket:
    message = "보호자 동반 입장"
else:
    message = "입장권 필요"
print(message)
print(not has_ticket, age >= 13 or has_ticket)

#테스트
to = int(input("숫자: "))

if to<0 or to>100:
    mess = "오류"
elif to>=90:
    mess = "A"
elif to>=80:
    mess = "B"
else:
    mess = "C"

print(mess)