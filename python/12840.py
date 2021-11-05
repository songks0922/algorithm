import sys

HOUR = 3600
MINUTE = 60
DAY = HOUR * 24

h, m, s = map(int, sys.stdin.readline().split())
for _ in range(int(sys.stdin.readline())):
    li = list(map(int, sys.stdin.readline().split()))
    if len(li) == 1 and li[0] == 3:
        print(h, m, s)
    else:
        t = h*HOUR + m*MINUTE + s
        t += (li[1] if li[0] == 1 else -li[1])
        if t < 0:
            t += DAY
        t = t%DAY
        h, m, s = t//HOUR, (t%HOUR)//MINUTE, t%MINUTE