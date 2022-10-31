from itertools import product

table = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
n = int(input())
cnt = 0
for i in range(1, 5):
    for j in product(table, repeat=i):
        if sum(j) == n:
            cnt += 1
print(cnt)