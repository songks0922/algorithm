num_str_a= input()
num_str_b= input()

num_bin_a=[int(x) for x in num_str_a]
num_bin_b=[int(x) for x in num_str_b]

if len(num_bin_a) > len(num_bin_b):
    num_bin_b = [0] * (len(num_bin_a) - len(num_bin_b)) + num_bin_b
elif len(num_bin_a) < len(num_bin_b):
    num_bin_a = [0] * (len(num_bin_b) - len(num_bin_a)) + num_bin_a

BASE=2
num_bin=[]
sum=0

carry = 0 ###2를 빌려와서 이런것 같음

for index in range(len(num_bin_a)-1, -1, -1):
    bit_a = num_bin_a[index]
    bit_b = num_bin_b[index]
    if num_bin_a[index] >= num_bin_b[index]: ####내가 고민한 부분
        sub_ = bit_a - bit_b     ###숫자가 같으면 그냥 뺴면 됨
        num_bin_a[index] = sub_
    elif num_bin_a[index] < num_bin_b[index]: ####내가 고민한 부분
        target_index = 0
        for i in range(index-1, -1, -1):
            if num_bin_a[i] == 1:
                num_bin_a[i] = 0
                target_index = i
                break
        for j in range(target_index + 1, index + 1):
            num_bin_a[j] += 1
            if j == index:
                num_bin_a[j] = 1
                break

all_zero = True
zero = True
for i in range(len(num_bin_a)):
    if zero and num_bin_a[i] == 0:
        continue
    elif zero and num_bin_a[i] == 1:
        zero, all_zero = False, False
        num_bin.append(num_bin_a[i])
    else:
        num_bin.append(num_bin_a[i])
if all_zero:
    num_bin.append(0)

print(f"Binary number={num_bin}")
