from sys import stdin, stdout

if __name__ == "__main__":
    n = stdin.readline()
    N = set(stdin.readline().split())
    m = stdin.readline()
    M = stdin.readline().split()

    for l in M:
        stdout.write('1\n') if l in N else stdout.write('0\n')
