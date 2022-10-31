import sys

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split(" "))
    A = []
    B = []

    for i in range(N):
        A.append(list(map(int, sys.stdin.readline().split(' '))))

    M, K = map(int, sys.stdin.readline().split(" "))

    for i in range(M):
        B.append(list(map(int, sys.stdin.readline().split(' '))))

    result = [[0 for _ in range(K)] for _ in range(N)]

    for n in range(N):
        for k in range(K):
            for m in range(M):
                result[n][k] += A[n][m] * B[m][k]
    for i in result:
        for j in i:
            print(j, end=' ')
        print()
