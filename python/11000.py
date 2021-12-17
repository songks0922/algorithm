from sys import stdin
import heapq

if __name__ == "__main__":
    n = int(stdin.readline())
    queue = []
    for i in range(n):
        queue.append(list(map(int, stdin.readline().split())))
    queue.sort()

    room = []
    heapq.heappush(room, queue[0][1])

    for i in range(1, n):
        if queue[i][0] < room[0]:
            heapq.heappush(room, queue[i][1])
        else:
            heapq.heappop(room)
            heapq.heappush(room, queue[i][1])
    print(len(room))