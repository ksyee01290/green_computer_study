def quote(price, quantity, shipping=3000):
    subtotal = price * quantity
    return subtotal + shipping

total = quote(8000,3)
print(total)
# 아래 마지막에 그냥 0으로 넣어도 가능하다
print(quote(8000,3,shipping=0))

#테스트
def area(a,b):
    return a*b

a = int(input("a: "))
b = int(input("b: "))
c = area(a,b)
if c == 30:
    mess = "네모 넓이가 맞다"
else:
    mess = "넓이가 맞지 않다."
print(mess)