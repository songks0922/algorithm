import random
i=0
lotto_str="" #뽑힌숫자
# while len(num)<11:   #while true는 무한 반복 되는것, 다른사람들은 while true 사용

while len(lotto_str)<11:
    num=random.randint(1,45) #num은 n번째 뽑힌 숫자
    num = str(num)
    if len(num) < 2:  # 1이나 2가 뽑히면 01,02로 되야 함
        lotto_str= "0" + str(num)

    else: # 똑같은 나오면 안됨, 비복원추출
        if lotto_str [i:i + 2]!= num:
            lotto_str+=num

        # elif num in num: #똑같은 수 있으면 안됨
        #     break #저장안함

    if len(lotto_str)>10:  #010203040506이 되면 빠져나와야 함
        break

print(lotto_str)