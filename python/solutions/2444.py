from sys import stdin

if __name__ == "__main__":
    n = int(stdin.readline())

    for i in range(1, n):
        print(' ' * (n - i) + '*' * (2 * i - 1))
    for i in range(n, 0, -1):
        print(' ' * (n - i) + '*' * (2 * i - 1))
