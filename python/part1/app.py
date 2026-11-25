import sys,json

print("app.py")
print("수업시간: ",60)
print("실행기 정보: ", sys.executable)

def sum_values(name,*args):
    total = sum(args)
    if name in pri:
        pri[name] +=total
    else:
        pri[name] =total

def profile(**kwargs):
    return kwargs

# 가격, 수량, 배송비
def quote(price, quantity, shipping=3000, is_member = False):
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

def printinfo():
    print()
    print("===========================================")
    print("=== 파이썬 스마트 스토어 & 학습 매니저 ===")
    print("1. 상품 목록 보기 (가격 정렬)")
    print("2. 주문 담기 및 견적 계산")
    print("3. 수량 일괄 정산 리포트 (컴프리헨션)")
    print("4. 보유 vs 관심 상품 비교 (집합 연산)")
    print("5. 주문 내역 JSON 저장 및 불러오기")
    print("6. 회원 프로필 / 추가 메모 등록 (**kwargs)")
    print("0. 종료")
    print()

def manu1():
    st = sorted(mes, key=lambda item: item[1], reverse=True)
    
    print(st)
    print("최고가상품: ",st[0])
    print("추천 top3: ",st[:3])

def manu2():
    # 사용자 입력 다음 배송비 관련 안에 sum_value 를 실행해야 제대로들어감
    name = ""
    item = ""
    is_member = False
    boo = False

    while True:
        print("1. 사용자 이름,회원,주문,수량")
        print("2. 배송비관련")
        print("3. 누적 주문금액")
        print("4. 메뉴로 되돌아가기")
        num = input("입력: ")
        if num == "1":
            name = input("이름: ").strip()

            if name not in user["name"]:
                print("사용자가 없습니다.")
                continue

            item = input("상품명: ")
            found = False
            price = 0

            for i in mes:
                if i[0] == item:
                    price = i[1]
                    found = True

            if found == False:
                print("상품이 없습니다.")
                continue

            try:
                raw_quantity = int(input("수량: "))
            except ValueError:
                print("정수를 입력하세요")

            member = input("회원 여부: ")
            if member == "y":
                is_member = True
            elif member == "n":
                is_member = False
            else:
                print("처음부터 다시")
                break

            if name not in raw:
                raw[name] = []

            raw[name].append([item, raw_quantity])
            print("주문완료")

        elif num == "2":
            for i in mes:
                if i[0] == item:
                    price = i[1]

            total = quote(price,raw_quantity,3000,is_member)

            if boo == False:
                sum_values(name,total)
                boo = True
            print("결제금액: ",total)


        elif num == "3":
            if name in pri:
                print(name, "누적 주문: ", raw[name])
                print(name, "누적 금액: ", pri[name])
            else:
                print("주문금액 없음")
        elif num == "4":
            print("메뉴로 되돌아갑니다.")
            break
        else:
            print("잘못 입력하셧습니다.")
            break

def manu3():
    #누적주문,금액 연동못함
    alist = [2,3,0,-1,1]
    price = 2000

    result = [n * price for n in alist if n>0]
    print("금액 리스트: ", result)

    report = {str(i+1):a for i, a in enumerate(result)}
    print("정산 리포트: ", report)

def manu4():
    nam1 = {"name":"교집합","mes":sorted(awned_items & wish_items)}
    nam2 = {"name":"차집합","mes":sorted(awned_items - wish_items)}
    nam3 = {"name":"합집합","mes":sorted(awned_items | wish_items)}
    print(nam1)
    print(nam2)
    print(nam3)

def manu5():
    #메인 연동 못함
    dick = {"oder": raw, "total_oder": 120000}

    text = json.dumps(dick, ensure_ascii=False)
    print(text)

    print("주문내역: ", json.loads(text)["oder"])


def manu6():
    x,y = (10,20)
    print("매장 좌표: ",x,y)

    name = input("이름: ")
    level = input("레벨: ")
    grade = input("등급: ")

    user["name"] = name
    user["level"] = level
    user["grade"] = grade

    profiles[name] = profile(**user)
    print(name,profile(**user))

pri = {}
raw = {}

profiles = {}
user = {}
mes = [("book",12000),("note",8000),("pen",1500),("bag",25000),("cup",6000)]

awned_items = {"book","note","cup"}
wish_items = {"pen","note"}

while True:
    printinfo()
    num = input("숫자 입력: ")
    if num == "1":
        manu1()
    elif num == "2":
        manu2()
    elif num == "3":
        manu3()
    elif num == "4":
        manu4()
    elif num == "5":
        manu5()
    elif num == "6":
        manu6()
    elif num == "0":
        break
    else:
        print("잘못입력하셧습니다.")
    
    



