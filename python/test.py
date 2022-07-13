from itertools import product
pi = "-00-"
#
# for i in product(["1","0"], repeat=pi.count("-")):
#     if '-' in pi:
#         replace = pi.replace("-", i[0], 1)
#         for j in range(1, len(i)):
#             replace = replace.replace("-", i[j], 1)
#         print(replace, end=" ")

# a = set(['1011', '1000', '1001'])
# b = set(['1001', '1000'])
#
# print(len(a - b))

a = {1: 'a', 2: 'b', 3: 'c'}

for i in list(a):
    print(a.get(i))


# temp = ['00--', '1100', '-01-']
# temp = ['101-', '10-0', '110-', '11-1', '1-11', '--00']
# temp_map = {}
# to_find_epi_list = []
# for pi in temp:
#     # print(pi + ": ", end="")
#     minterm = []
#     for i in product(["1","0"], repeat=pi.count("-")):
#         if '-' in pi:
#             replace = pi.replace("-", i[0], 1)
#             for j in range(1, len(i)):
#                 replace = replace.replace("-", i[j], 1)
#             minterm.append(replace)
#             # print(replace, end=" ")
#             to_find_epi_list.append(replace)
#             temp_map[pi] = minterm
#         else:
#             temp_map[pi] = [pi]
#             print(pi, end=" ")
#     # print()
# print(temp_map)
# print(to_find_epi_list)
# to_find_epi_list = [minterm for minterm in to_find_epi_list if to_find_epi_list.count(minterm) == 1]
# print(to_find_epi_list)
# find_epi_set = set()
# for pi, minterm in temp_map.items():
#     for epi in to_find_epi_list:
#         if epi in minterm:
#             find_epi_set.add(pi)
#
# print(find_epi_set)
# l = []
# l += find_epi_set
# print(l)