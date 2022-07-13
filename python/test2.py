Jobs =  [30, 27, 24, 24, 43, 32, 55, 34, 37, 29, 31, 40, 45, 32, 60, 71, 59]
M = int(input('기계 갯수는 몇 개 인가요? ')) ## 머신 수
print('Jobs =',Jobs,'\n# of Jobs =',len(Jobs),', # of Machines =',M,'\n')

task = [[] for _ in range(M)]

New_Jobs = sorted(Jobs, reverse=True)
job = 0
cycle = False
for j in range(0, len(New_Jobs), M):

    for i in range(0, M):
        if cycle:
            task[M-i-1].append(New_Jobs[j+i])
        else:
            task[i].append(New_Jobs[j+i])
    cycle = True if not cycle else False
def PrintGanttChart(C):
    for c in range(0,M):
        print(' Mach',c+1,': Time =',sum(C[c]),C[c])
    # print('>> Final Completion Time (C.T.) =',max(A) )

PrintGanttChart(task)