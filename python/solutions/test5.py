
#2진수의 16진수 변환을 위해 작성한 코드와 실행화면을 캡처하여 업로

num_bin = "001011110011"
print(f"Binary number = {num_bin}")

BIT = 4
num_bin = num_bin[::-1]
num_oct = "" #?

cnt_bit = 0
while cnt_bit < len(num_bin):
    cnt, sum_ = 0, 0

    while cnt < BIT and cnt_bit < len(num_bin):
        sum_ += 2**cnt * int(num_bin[cnt_bit]) #cnt는 index 말하는거 맞음? 1101(0123), cnt_bit=1101
        cnt += 1 #승수가 1씩 증가
        cnt_bit += 1 #이것도 index 말한느거 맞음?

    if sum_ == 10:
        num_oct = "A" + num_oct  # 질문 위에 num_dec//base에서 hex_num 써야하는거 아님?
        # 만약 177이라고 하면 " 16*11+1=B+1이 나오는건가?
    elif sum_ == 11:
        num_oct = "B" + num_oct
    elif sum_ == 12:
        num_oct = "C" + num_oct
    elif sum_ == 13:
        num_oct = "D" + num_oct
    elif sum_ == 14:
        num_oct = "E" + num_oct
    elif sum_ == 15:
        num_oct = "F" + num_oct
    else:
        num_oct = str(sum_) + num_oct

print(f"Octal number = {num_oct}")