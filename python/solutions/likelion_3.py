from sys import stdin

if __name__ == "__main__":
    N = int(stdin.readline())
    max_english, max_math = 0, 0
    for i in range(N):
        english, math = map(int, stdin.readline().split(' '))
        if max_english < english:
            max_english, max_math = english, math
        elif max_english == english and max_math > math:
            max_math = math
    print("{} {}".format(max_english, max_math))
