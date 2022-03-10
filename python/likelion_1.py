from sys import stdin

if __name__ == "__main__":
    word = stdin.readline()
    for alpha in word:
        if alpha != '\n':
            order = ord(alpha) - ord('a') + 1
            print(order, end=" ")

