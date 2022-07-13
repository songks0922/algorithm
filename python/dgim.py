import random
import matplotlib.pyplot as plt
import numpy as np


class Bucket:
    def __init__(self, start, end, sub_sum=None):
        self.start = start
        self.end = end
        self.sub_sum = sub_sum if sub_sum is None else sub_sum

    def __repr__(self):
        return f"({self.start},{self.end})"


class DGIM:
    def __init__(self):
        self.bucket_tower = [[]]
        self.ts = 0

    def put(self, bit):

        if bit == 1:

            self.bucket_tower[0].insert(0, Bucket(self.ts, self.ts))

            layer = 0
            while len(self.bucket_tower[layer]) > 2:
                if len(self.bucket_tower) <= layer + 1:
                    self.bucket_tower.append([])
                b1 = self.bucket_tower[layer].pop()
                b2 = self.bucket_tower[layer].pop()

                b1.end = b2.end

                self.bucket_tower[layer + 1].insert(0, b1)
                layer += 1

        self.ts += 1

    def count(self, k):
        s = self.ts - k

        cnt = 0

        for layer, buckets in enumerate(self.bucket_tower):
            for bucket in buckets:
                if s <= bucket.start:
                    cnt += (1 << layer)
                elif s <= bucket.end:
                    cnt += (1 << layer) * (bucket.end - s + 1) // (bucket.end - bucket.start + 1)
                    return cnt
                else:
                    return cnt
        return cnt

    def reset(self):
        self.ts = 0
        self.bucket_tower = [[]]

class DGIM_int:
    def __init__(self):
        self.bucket_tower = [[]]
        self.ts = 0

    def put(self, num):

        self.bucket_tower[0].insert(0, Bucket(self.ts, self.ts, num))

        layer = 0
        while len(self.bucket_tower[layer]) > 2:
            if len(self.bucket_tower) <= layer + 1:
                self.bucket_tower.append([])

            if self.bucket_tower[layer][1].sub_sum + self.bucket_tower[layer][2].sub_sum <= (1 << layer+1):
                b1 = self.bucket_tower[layer].pop()
                b2 = self.bucket_tower[layer].pop()

                b1.end = b2.end
                b1.sub_sum += b2.sub_sum
            else:
                b1 = self.bucket_tower[layer].pop()

            self.bucket_tower[layer + 1].insert(0, b1)
            layer += 1

        self.ts += 1

    def sum(self, k):
        s = self.ts - k

        dgim_sum = 0

        for layer, buckets in enumerate(self.bucket_tower):
            for bucket in buckets:
                if s <= bucket.start:
                    dgim_sum += bucket.sub_sum
                elif s <= bucket.end:
                    dgim_sum += round(bucket.sub_sum * ((bucket.end - s + 1) / (bucket.end - bucket.start + 1)))
                    return dgim_sum
                else:
                    return dgim_sum
        return dgim_sum


def to_binary(num):
    num_bin = [0 for i in range(MAX_BIT)]
    i = 3
    while num > 0:
        num_bin[i] = num % 2
        num //= 2
        i -= 1
    return num_bin


dgim = DGIM()
MAX_BIT = 4 # 한정된 비트 상수 선언
bitstream = [[] for i in range(MAX_BIT)]

intstream = [random.randint(0, 15) for i in range(10000)]

# 방법 1

for i in intstream:
    each_bit = to_binary(i)
    for j in range(MAX_BIT):
        bitstream[j].append(each_bit[MAX_BIT - j - 1])


dgim_sum_bit_list = []

for k in range(1, 2001):
    index = 0
    dgim_sum = 0
    for each_bitstream in bitstream:
        for bit in each_bitstream:
            dgim.put(bit)
        dgim_sum += dgim.count(k) * (1 << index)
        index += 1
        dgim.reset()
    dgim_sum_bit_list.append(dgim_sum)

# 방법 2

dgim_int = DGIM_int()

dgim_sum_int_list = []
real_sum = []

for num in intstream:
    dgim_int.put(num)

for k in range(1, 2001):
    dgim_sum_int_list.append(dgim_int.sum(k))
    print(dgim_sum_int_list[-1])
    real_sum.append(sum(intstream[-k:]))

# 그래프 그리는 부분
x = np.arange(1, 2001)
plt.plot(x, np.array(dgim_sum_bit_list), label="DGIM method 1 sum")
plt.plot(x, np.array(dgim_sum_int_list), label="DGIM method 2 sum")
plt.plot(x, np.array(real_sum), label="real sum")
plt.legend()
plt.show()
