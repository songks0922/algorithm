import sys

if __name__ == "__main__":
    words = sys.stdin.readline().strip().upper()
    unique = list(set(words))

    cntList = []
    for x in unique :
        cnt = words.count(x)
        cntList.append(cnt)

    if cntList.count(max(cntList)) > 1:
        print('?')
    else:
        max_index = cntList.index(max(cntList))
        print(unique[max_index])
