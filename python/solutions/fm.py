import mmh3
import math
import random
import matplotlib.pyplot as plt
from tqdm import tqdm

HASH_CNT = 25
GROUP_CNT = 2

class FM:
    def __init__(self, domain_size):
        self.bitarray = 0
        self.domain_size = domain_size
        self.n_bits = math.ceil(math.log2(domain_size))
        self.mask = (1 << self.n_bits) - 1
        self.seed = random.randint(0, 9999999)

    def put(self, item):
        h = mmh3.hash(item, self.seed) & self.mask
        r = 0

        if h == 0: return
        while (h & (1 << r)) == 0:
            r += 1

        self.bitarray |= (1 << r)

    def size_v2(self):

        R = 0
        while (self.bitarray & (1 << R) != 0):
            R += 1
        return 2 ** R / 0.77351

    def size_v1(self):

        R = len(bin(self.bitarray)) -3 #비트의 총 자리수 -1이 1이 제일 마지막으로 나오는 인덱스값이고 bin함수를 사용하면 0b가 앞에 붙어 나오므로 -3을 하면 인덱스 값이 나옴
        return 2 ** R


class FM_improve:
    def __init__(self, domain_size, hash_cnt):
        self.hash_cnt = hash_cnt
        self.bitarray = [0 for _ in range(self.hash_cnt)]
        self.domain_size = domain_size
        self.n_bits = math.ceil(math.log2(domain_size))
        self.mask = (1 << self.n_bits) - 1
        # self.seed = random.randint(0, 9999999)
        self.seeds = [random.randint(0, 999999) for i in range(self.hash_cnt)]

    def put(self, item):
        for i in range(self.hash_cnt):
            
            h = mmh3.hash(item, self.seeds[i]) & self.mask
            r = 0
    
            if h == 0: return
            while (h & (1 << r)) == 0:
                r += 1
    
            self.bitarray[i] |= (1 << r)

    def size(self):

        estimate = [0 for _ in range(self.hash_cnt)]
        pivot_sum = 0
        for i in range(self.hash_cnt):
            R = 0
            while (self.bitarray[i] & (1 << R) != 0):
                R += 1
            estimate[i] = 2 ** R / 0.77351
        sampling_est = list_sampling(estimate, math.ceil(self.hash_cnt / GROUP_CNT))

        for each in sampling_est:
            pivot_sum += each[len(each) // 2]

        return pivot_sum / len(sampling_est)


def list_sampling(list_, n):
    return [sorted(list_[i:i+n]) for i in range(0, len(list_), n)]


fm = FM(1000000)
fm_improve = FM_improve(1000000, HASH_CNT)
tset = set()
x = []
y1 = []
y2 = []
y3 = []

for i in tqdm(range(1000000)):
    item = str(random.randint(0, 100000))
    fm.put(item)
    fm_improve.put(item)
    tset.add(item)

    x.append(len(tset))
    y1.append(fm.size_v1())
    y2.append(fm.size_v2())
    y3.append(fm_improve.size())

plt.scatter(x, y1, color='b', label="version1")
plt.scatter(x, y2, color='orange', label="version2")
plt.scatter(x, y3, color='m', label="improved version2")
plt.plot(x, x, color="r", label="real")
plt.legend(loc="best")
plt.title(f"hash function count: {HASH_CNT}, group count: {GROUP_CNT}")
plt.show()
