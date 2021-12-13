from sys import stdin

if __name__ == "__main__":
    N = int(stdin.readline())
    town = []

    for i in range(N):
        town.append(list(map(int, stdin.readline().split())))
    town.sort(key=lambda x: x[0])

    mid = round(sum(p for _, p in town)/2)
    cnt = 0
    for num, people in town:
        cnt += people
        if cnt >= mid:
            print(num)
            break