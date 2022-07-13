from itertools import product

def hamming_distance(m1, m2):
    dist = 0

    for n1, n2 in zip(m1, m2):
        if n1 != n2:
            dist += 1
    return dist


def merge(m1, m2, impicants, answer):
    if hamming_distance(m1, m2) == 1:
        merge_str = ""
        for bit in range(len(m1)):
            if m1[bit] == m2[bit]:
                merge_str += m1[bit]
            else:
                merge_str += "2"
        impicants[merge_str.count('1')].append(merge_str)
        if m1 in answer:
            answer.remove(m1)
        if m2 in answer:
            answer.remove(m2)
        if merge_str not in answer:
            answer.append(merge_str)


def solution(minterm):
    answer = []
    n = minterm[0]
    impicants = [[[] for _ in range(n-i+1)] for i in range(n)]
    max_len, term_cnt = f'0{n}b', minterm[1]

    for each_minterm in minterm[2:]:
        s = format(each_minterm, max_len)
        impicants[0][s.count('1')].append(s)
        answer.append(s)

    for total in range(len(impicants)):
        for i in range(len(impicants[total]) - 1):
            for j in range(len(impicants[total][i])):
                for k in range(len(impicants[total][i + 1])):
                    m1, m2 = impicants[total][i][j], impicants[total][i + 1][k]
                    merge(m1, m2, impicants[total+1], answer)
    n -= 1

    answer.sort(key=int)

    pi_map = {}
    to_find_epi_list = []

    for pi in answer:
        minterm = []
        for i in product(["1","0"], repeat=pi.count("2")):
            if '2' in pi:
                replace = pi.replace("2", i[0], 1)
                for j in range(1, len(i)):
                    replace = replace.replace("2", i[j], 1)
                minterm.append(replace)
                to_find_epi_list.append(replace)
                pi_map[pi] = minterm
            else:
                pi_map[pi] = [pi]
                to_find_epi_list.append(pi)

    to_find_epi_list = [minterm for minterm in to_find_epi_list if to_find_epi_list.count(minterm) == 1]

    find_epi_set = set()
    for pi, minterm in pi_map.items():
        for epi in to_find_epi_list:
            if epi in minterm:
                find_epi_set.add(pi)


    find_epi_list = list(find_epi_set)
    find_epi_list.sort(key=int)
    answer.append("EPI")
    answer += find_epi_list

    for i in range(len(answer)):
        answer[i] = answer[i].replace("2", "-")
    return answer


print(solution([3, 6, 0, 1, 2, 5, 6, 7]))
# print(solution([3, 4, 0, 1, 2, 3]))
# print(solution([4, 8, 0, 4, 8, 10, 11, 12, 13, 15]))
# print(solution([3, 4, 0, 1, 5, 7]))
print(solution([4, 7, 0, 1, 2, 3, 10, 11, 12]))
