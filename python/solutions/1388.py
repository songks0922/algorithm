from sys import stdin
from  collections import deque

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        if graph[x][y] == "-":
            graph[x][y] = "1"
            if y + 1 < m and graph[x][y + 1] == "-":
                queue.append((x, y + 1))
        elif graph[x][y] == "|":
            graph[x][y] = "1"
            if x + 1 < n and graph[x + 1][y] == "|":
                queue.append((x + 1, y))
    return graph[n-1][m-1]

n, m = map(int, stdin.readline().split())
cnt = 0
graph = [list(stdin.readline()) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if graph[i][j] != '1':
            bfs(i, j)
            cnt += 1

print(cnt)