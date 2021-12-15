from sys import stdin, exit

if __name__ == "__main__":
    n = int(stdin.readline())
    k = int(stdin.readline())
    post = sorted(list(map(int, stdin.readline().split())))

    if k >= n:
        print(0)
        exit()
    dist = []
    for i in range(1, n):
        dist.append(post[i] - post[i-1])
    dist.sort(reverse=True)

    for i in range(k-1):
        dist.pop(0)
    print(sum(dist))
