import sys

if __name__ == "__main__":
    expression = list(map(str, sys.stdin.readline().strip().split("-")))
    subtraction = []
    for each in expression:
        sum = 0
        temp = list(map(int, each.split("+")))
        for i in temp:
            sum += i
        subtraction.append(sum)
    result = subtraction[0]
    for i in range(1, len(subtraction)):
        result -= subtraction[i]
    print(result)