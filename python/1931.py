import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline())
    room = []

    for i in range(n):
        start, end = map(int, sys.stdin.readline().split())
        room.append([start, end])

    # 시작 시간을 기준으로 정렬 한 후에 종료시간이 빠른 기준으로 정렬 한다
    room.sort(key=lambda x: x[0])
    room.sort(key=lambda x: x[1])

    cnt = 1
    end = room[0][1]
    for i in range(1, n):
        if room[i][0] >= end:
            cnt += 1
            end = room[i][1]
    print(cnt)