import sys

n, snake_len = map(int, sys.stdin.readline().split(' '))
fruits = list(map(int, sys.stdin.readline().split(' ')))

fruits.sort()

for fruit in fruits:
    if snake_len >= fruit:
        snake_len += 1
    else:
        break
print(snake_len)