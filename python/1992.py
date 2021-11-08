import sys

video = []


def compress(n, y, x):
    if n == 1:
        sys.stdout.write(video[y][x])
        return
    zero, one = True, True
    for i in range(y, y + n):
        for j in range(x, x + n):
            if int(video[i][j]):
                zero = False
            else:
                one = False
    if zero:
        sys.stdout.write("0")
    elif one:
        sys.stdout.write("1")
    else:
        sys.stdout.write("(")
        compress(n // 2, y, x);
        compress(n // 2, y, x + n // 2);
        compress(n // 2, y + n // 2, x);
        compress(n // 2, y + n // 2, x + n // 2);
        sys.stdout.write(")")
    return


if __name__ == "__main__":
    n = int(sys.stdin.readline())

    for i in range(n):
        video.append(sys.stdin.readline().strip())
    compress(n, 0, 0)
    sys.stdout.write("\n")
