import sys

if __name__ == "__main__":
    words = list(map(str, sys.stdin.readline().split()))
    print(len(words))