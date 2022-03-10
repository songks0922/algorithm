from sys import stdin

def add(A, B):
    print(A+B, end = " ")

def sub(A, B):
    print(A-B, end = " ")

def multi(A, B):
    print(A*B, end = " ")

def quotient(A, B):
    print(A//B, end = " ")

def remainder(A, B):
    print(A%B, end = " ")

if __name__ == "__main__":
    A, B = map(int, stdin.readline().split(' '))
    add(A, B)
    sub(A, B)
    multi(A, B)
    quotient(A, B)
    remainder(A, B)
