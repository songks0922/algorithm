import random


lotto_str = ""
while len(lotto_str)<10:
    num = str(random.randint(1, 45))

    if len(num) < 2:  # 1이나 2가 뽑히면 01,02로 되야 함
        lotto_str= "0" + str(num)


    if lotto_str == "": # 맨 처음에는 아무 숫자도 안들어 있기 때문에 무조건 저장함
        lotto_str += num
    else:
        i = 0
        is_contain = False
        while i < len(lotto_str):
            if lotto_str[i:i+2] == num:
                is_contain = True
                break
            i += 2
        if not is_contain:
            lotto_str += num

print(lotto_str)
