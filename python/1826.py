import sys
import heapq

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    gasStation = []
    for i in range(N):
        gasStation.append(list(map(int, sys.stdin.readline().split())))
    L, P = map(int, sys.stdin.readline().split())

    gasStation.sort(reverse=True)
    heap = []
    cnt = 0

    while P < L:
        while gasStation and gasStation[-1][0] <= P:
            dist, fuel = gasStation.pop()
            heapq.heappush(heap, -fuel)
        if not heap:
            break
        P -= heapq.heappop(heap)
        cnt += 1
    if L > P:
        cnt = -1
    print(cnt)
