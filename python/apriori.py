from itertools import combinations

def make_candidate(freq_itemsets, k):
    candidates = set()
    for itemset1 in freq_itemsets:
        for itemset2 in freq_itemsets:
            union = itemset1 | itemset2
            if len(union) == k:
                for item in union:
                    if union - {item} not in freq_itemsets:
                        break
                else:
                    candidates.add(union)
    return candidates

def filter(candidates, k, s):
    itemsets_cnt_k = {}
    global item_cnt_all
    with open("groceries.csv", "r") as f:
        for line in f:
            basket = line.strip().split(",")
            for comb in combinations(basket, k):
                comb = frozenset(comb)
                if comb in candidates:
                    if comb not in itemsets_cnt_k:
                        itemsets_cnt_k[comb] = 0
                    itemsets_cnt_k[comb] += 1

    freq_itemsets = set(itemset for itemset, cnt in itemsets_cnt_k.items() if cnt >= s)
    item_cnt_all = {**item_cnt_all, **itemsets_cnt_k}
    return freq_itemsets

# item 개수 구하기

item_cnt = {}
s = 60
c = 0.57
with open("groceries.csv", "r") as f:
    for line in f:
        basket = line.strip().split(",")
        for item in basket:
            if item not in item_cnt:
                item_cnt[item] = 0
            item_cnt[item] += 1

freq_itemsets = set(frozenset([item]) for item, cnt in item_cnt.items() if cnt >= s)
freq_itemsets_all = freq_itemsets.copy()
item_cnt_all = {}

for item, cnt in item_cnt.items():
    item = frozenset([item])
    item_cnt_all[item] = cnt

k = 2

while len(freq_itemsets) > 0:
        candidates = make_candidate(freq_itemsets, k)
        freq_itemsets = filter(candidates, k, s)
        freq_itemsets_all |= freq_itemsets
        # print(k, len(candidates), len(freq_itemsets))
        k += 1

for fi in freq_itemsets_all:
    for k in range(1, len(fi)):
        for j in combinations(fi, k):
            j = frozenset(j)
            support_union, support_left = item_cnt_all.get(fi), item_cnt_all.get(j)
            each_confidence = round(support_union/support_left, 3)
            if (c <= each_confidence):
                print(f'{", ".join(j)} -> {", ".join(fi-j)}: c={support_union}/{support_left}={each_confidence}')