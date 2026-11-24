items = ["book","pen","bag"]
#-1로 오른쪽부터 읽기 가능
print(items[0],items[-1])
#3인덱스는 비포함이라는뜻 1인덱스부터 2인덱스까지 출력
print(items[1:3])
#append 리스트에 값 추가
items.append("cup")
items[0] = "note"
print(items)

point = (10,20,30)
x,y,z = point
print(x,y,z)

#테스트
name = ["근원","짱구","철수","맹구","훈이"]

print(name[:3])
print(name[3:])
#기본시스템은 왼족부터 오른쪽으로 출력이된다
print(name[-2:])
print(name[:-2])
#step가 오른쪽부터여서 역순출력 step는 옵션 생략가능
print(name[::-1])
print(name[-1::])