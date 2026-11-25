def sum_values(*args):
    return sum(args)

def profile(**kwargs):
    return kwargs

print(sum_values(3,5,7))
print(profile(name="민수", level="basic"))
#()튜플 []리스트 [(,)] 딕셔너리 key,값 으로 구성 {}딕셔너리 형
items = [("pen",1500), ("book",120000)]

st = sorted(items, key=lambda item: item[1], reverse=True)
print(st)
#print(items.sorted(items, key=lambda item: item[1], reverse=False))

#테스트
def basket_total(*prices):
    return sum(prices)

def basket(**kwargs):
    return kwargs

items = [("aa",1000),("bbb",11000),("d",3000),("ccccc",8000),("eeee",5000)]
itemss = ["asdfasdf","asdf","efwefw"]
print(basket_total(40,50,20))
print(sorted(itemss, key=lambda str: len(str), reverse=True))

st = sorted(items, key=lambda item: item[1], reverse=True)
print(st)

# 사전식 길이 len(item) 에대한 길이
# st = sorted(items, key=lambda item: [item[0],len(item)], reverse=True)
# print(st)