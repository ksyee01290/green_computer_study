import json
student = {"name":"민수","score":80}
student["score"] += 5
print(student.get("city","미입력"))

print("==========")
text = json.dumps(student, ensure_ascii=False)
# 자동 형변환
print(json.loads(text)["score"])

print("==========")
a={"book","pen","book"}
b={"pen","bag"}
print(sorted(a & b))
print(sorted(a - b))
print(sorted(a | b))

a = {"python","streamlit"}
b = {"python","RAG"}
print(sorted(a & b))
student = {"name": "민수", "subjects": sorted(a | b)}
print(json.dumps(student, ensure_ascii=False))

#예제3
stock = {"book": 3, "pen": 10}
stock["bag"] = 2
stock["pen"] -=4
print(stock.get("cup",0), stock["pen"])
for name, count in stock.ltems():
    print(name, count)
text = json.dumps(stock, ensure_ascii=False)
loaded = json.loads(text)
print(text, loaded == stock)
print(sorted({"a","b","c"} - {"b"}))

#테스트
a = {"수학","과학","영어","국어"}
b = {"수학","미술","과학"}

print("공통과목: ",sorted(a&b))
print("한반에만 있는과목: ",a)

student = {"name":"철수","subjects":sorted(a-b)}
print(student)

text = json.dumps(student, ensure_ascii=False)
print(json.loads(text)["subjects"])