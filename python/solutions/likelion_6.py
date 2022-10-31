from sys import stdin

board = [[0 for col in range(20)] for row in range(20)]
#우상, 우, 우하, 하
dx, dy = [-1, 0, 1, 1], [1, 1, 1, 0]

def check_range(x, y):
    if (0 <= x and x < 20) and (0 <= y and y < 20):
        return True
    return False

def solve(x, y, player):

    cnt = 1
    move = 4

    for k in range(4):
        ax = x + dx[k]
        ay = y + dy[k]
        while move:

            move -= 1
            if not check_range(ax, ay) or board[ax][ay] == 0 or board[ax][ay] != player:
                move += 1
                break
            else:
                cnt += 1
            ax += dx[k]
            ay += dy[k]

        ax = x - dx[k]
        ay = y - dy[k]

        while move:
            move -= 1
            if not check_range(ax, ay) or board[ax][ay] == 0 or board[ax][ay] != player:
                move += 1
                break
            else:
                cnt += 1
            ax -= dx[k]
            ay -= dy[k]

        if cnt == 5:
            if player == 1:
                return "CS"
            else:
                return "YH"


def init(N):
    for i in range(N):
        x, y = map(int, stdin.readline().split(' '))
        # (0,0)부터 시작하도록 수정 1은 철수 2는 영희
        x -= 1
        y -= 1
        if i % 2 == 0:
            board[y][x] = 1
        else:
            board[y][x] = 2
        ans = solve(y, x, board[y][x])

        if ans != None:
            return ans

if __name__ == "__main__":

    N = int(stdin.readline())
    print(init(N))
