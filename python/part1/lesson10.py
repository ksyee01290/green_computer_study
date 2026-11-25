values = [2,3,0]
#컨프리헨션
totals = [n*8000 for n in values if n>0]
report = {str(i+1): v for i, v in enumerate(totals)}

print(totals)
print(report)

try:
    quantity = int("abc")
except ValueError:
    print("정수를 입력하세요")

print("===========")

#예제2
raw_scores = ["80","abc","60","-1","101"]
scores, errors = [],[]

for raw in raw_scores:
    try:
        score = int(raw)
        if not 0<= score <= 100:
            raise ValueError("range")
        scores.append(score)
    except ValueError:
        errors.append(raw)
passed = [score for score in scores if score >= 60]
print(passed, errors)


print("===========")
#예제3
raw = ["3","x","7","","12"]
numbers = []
for value in raw:
    try:
        numbers.append(int(value))
    except ValueError:
        print("건너뜀: ",repr(value))
squares = [n*n for n in numbers if n%2 == 1]
labels = {n: "짝수" if n %2 == 0 else "홀수" for n in numbers}
print(numbers, squares)
print(labels)


#테스트
print("===========")
values = [-1,101,30,50,80,66,58,98,88,"abc"]
abcs = []
error = []

for i in values:
    try:
        abc = int(i)
        if not 0< abc <100:
            raise ValueError("range")
        abcs.append(abc)
    except ValueError:
        error.append(i)
passd = [abc for abc in abcs if abc>=60]
mes = [("통과",passd),("오류",error)]
print(mes)



# cde = [n for n in values if n>0 and n<100]
# hum = [v for v in cde if v>60]
# huum = {str(i+1): v for i, v in enumerate(hum)}
# print(huum)

# try:
#     print(huum)
# except ValueError:
#     print("빈입력에도 실패안함")

#컴프리헨션 [표현식 for 변수 in 이터러블 if 조건식]
#딕셔너리 사용할때 : 를 이용해서 키와 값을 분리한다.