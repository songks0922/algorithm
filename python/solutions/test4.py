answer = ""
while True:
    num = int(input("숫자 입력: "))
    if num == -1:
        break
    else:
        answer = str(num) + answer
        print(answer)