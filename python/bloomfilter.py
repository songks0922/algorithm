import math
import mmh3
import random
import string
import matplotlib.pyplot as plt

TOTAL = 1000
REAL =  500
NOT_IN = TOTAL - REAL
class BloomFilter:
    #capacity: m
    def __init__(self, capacity, fp_prob):
        self.capacity = capacity
        self.fp_prob = fp_prob
        self.bitarray = 0
        self.n_bits = math.ceil(-math.log(fp_prob, math.e) * capacity / (math.log(2, math.e) ** 2))
        self.n_hashs = round(self.n_bits / capacity * math.log(2, math.e))
        self.seeds = [random.randint(0, 999999) for i in range(self.n_hashs)]

    def put(self, item):

        for i in range(self.n_hashs):
            pos = mmh3.hash(item, self.seeds[i]) % self.n_bits
            self.bitarray |= (1 << pos)

    def test(self, item):
        for i in range(self.n_hashs):
            pos = mmh3.hash(item, self.seeds[i]) % self.n_bits

            if self.bitarray & (1 << pos) == 0:
                return False
        return True

def randomAccount():
    srting_pool = string.ascii_letters
    email = ''.join(random.choice(srting_pool) for _ in range(6))
    return email


def init_put(test_put_list):
    for _ in range(1000):
        account = randomAccount()
        if account not in test_put_list:
            test_put_list.append(account)
            bloom.put(account)
        else:
            _ -= 1

def init_test(test_list):
    test_list += random.sample(test_put, REAL)

    for _ in range(NOT_IN):
        account = randomAccount()
        if account not in test_list:
            test_list.append(account)
        else:
            _ -= 1
test_list = []
for _ in range(20):

    bloom = BloomFilter(1000, 0.1)

    test_put = []
    test = []
    init_put(test_put)
    init_test(test)
    real_cnt = 0
    test_cnt = 0
    for i in range(TOTAL):
        if bloom.test(test[i]) and test[i] not in test_put:
            test_cnt += 1
        if test[i] not in test_put:
            real_cnt += 1
        # print(f'{test[i]} : {bloom.test(test[i])} || real_test => {test[i]} : {test[i] in test_put}')
    test_list.append(test_cnt / real_cnt)

plt.axhline(0.1, color="r", label="input_fp")
plt.scatter([i for i in range(1, 21)], test_list, label="real_fp")
plt.legend()
plt.show()