import sys

size = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split(' ')))
total_score = 0

for i in range(size):
    total_score += (score[i]*100)/max(score)

print(total_score/size)