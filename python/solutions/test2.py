from sys import stdin
import copy
import pprint
from collections import deque


def bfs(start, visit_list):
    queue = deque()

    queue.append(start)
    visit_list[start] = 1

    while queue:
        node = queue.popleft()
        print(node, end=" ")

        for i in range(1, n + 1):
            if visit_list[i] == 0 and adjacent_matrix[node][i] == 1:
                queue.append(i)
                visit_list[i] = 1


def dfs(node, visit_list):
    visit_list[node] = 1
    print(node, end=" ")
    for i in range(1, n + 1):
        if visit_list[i] == 0 and adjacent_matrix[node][i] == 1:
            dfs(i, visit_list)


def dfs_stack(node, visit_list):
    stack = deque()
    visit_list[node] = 1
    stack.append(node)
    print(node, end=" ")
    while stack:
        node = stack.pop()
        if not visit_list[node]:
            print(node, end=" ")
            visit_list[node] = 1

        for i in range(len(adjacent_matrix[node]) - 1, -1, -1):
            if adjacent_matrix[node][i] == 1 and visit_list[i] == 0:
                stack.append(i)


if __name__ == "__main__":
    n, m, v = map(int, stdin.readline().split())

    adjacent_matrix = [[0] * (n + 1) for _ in range(n + 1)]
    visit = [0] * (n + 1)
    adjacent_list = [[] for _ in range(n + 1)]

    for i in range(m):
        x, y = map(int, stdin.readline().split())
        adjacent_matrix[x][y] = 1
        adjacent_matrix[y][x] = 1

        adjacent_list[x].append(y)
        adjacent_list[y].append(x)

    # dfs(v, copy.deepcopy(visit))
    # print()
    # sorted list of adjacent_list by ascending order
    for i in range(1, n + 1):
        adjacent_list[i].sort()

    dfs_stack(v, copy.deepcopy(visit))
    print()
    bfs(v, copy.deepcopy(visit))

    pprint.pprint(adjacent_list)