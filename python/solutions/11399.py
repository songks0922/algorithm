import sys

if __name__ == "__main__":
    n = sys.stdin.readline()
    times = list(map(int, sys.stdin.readline().split()))
    times.sort()
    sum = 0

    for i in range(len(times)):
        for j in range(i+1):
            sum += times[j]
    else:
        print(sum)