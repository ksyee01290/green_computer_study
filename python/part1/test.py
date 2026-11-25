mes = [("book",12000),("note",8000),("pen",1500),("bag",25000),("cup",6000)]



od ={}
raw = []
def add(name,*args):
    total = sum(args)

    if name in od:
        od[name] +=total
    else:
        od[name] =total

def quote(price, quantity, shipping=3000):
    is_member = True
    total = price * quantity
    if total < 0:
        message = "금액 오류"
    elif total >= 30000 and is_member:
        message = "무료 배송"
        shipping = 0
    else:
        message =  "배송비 3000원"
        shipping = 3000
    print(message)

    return total + shipping

qu = 0
# while True:
#     name = input("상품: ")
#     raw_quantity = int(input("수량: "))
#     raw.append(raw_quantity)
#     if raw_quantity == 3:
#         break
    # for i in mes:
    #     if i[0] == name:
    #         qu = quote(i[1],raw_quantity)
    #         add(i[0],qu)
    #         print(od)
    #         break

def clean(raw_values):
    valid = []
    for i in raw_values:
        try:
            n = int(i)
            if not n > 0:
                raise ValueError("range")
            valid.append(n)
        except ValueError:
            print
    return valid

val = clean(raw)

#total = [i+1 for i in mes]
# for i in mes:
#     if i[0] == i[0]:
#         val.append(i[1])


report = {i[0]: mes for i[0], mes in enumerate(mes)}

print(report)


for i in range(1,5):
    raw_quantity = int(input("수입력"))

print(raw_quantity)