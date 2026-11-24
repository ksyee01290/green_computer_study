total = 0
for quantity in [1,0,3]:
    if quantity ==0:
        continue
    total += quantity
print(total)

attempts =0
while attempts<3:
    attempts+=1
    if attempts == 2:
        break
print(attempts)

total=0
for number in range(1,5):
    if number % 2 !=0:
        continue
    total += number
print(total)

#테스트

total=0
for number in range(1,11):
    if number % 2 !=0:
        continue
    total += number
print(total)
print("==============================")
total=0
for number in range(1,11):
    if number % 2 ==0:
        continue
    total += number
print(total)
print("==============================")
for number in range(1,11):
    if number % 2 !=0:
        continue
    print(number)
print("==============================")
total=0
while total < 10:
    total+=1
    if total % 2 != 0:
        print(total)