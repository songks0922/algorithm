b1, b2 = map(str, input().split())
b1 = int(b1, 2)
b2 = int(b2, 2)
result = b1 + b2

print(bin(result)[2:])