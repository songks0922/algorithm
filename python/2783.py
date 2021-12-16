from sys import stdin

if __name__ == "__main__":
    x, y = map(int, stdin.readline().split())

    v = x*1000 / y
    N = int(stdin.readline())

    for i in range(N) :
        a, b = map(int, stdin.readline().split())
        v2 = a*1000 / b
        if v > v2 :
            v = v2

    print(round(v, 2))
