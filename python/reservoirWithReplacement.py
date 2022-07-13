import random
import matplotlib.pyplot as plt
import numpy as np


class Reservoir:
    def __init__(self, k):
        self.sampled = []
        self.k = k
        self.cnt = 0

    def put(self, item):
        if self.cnt < self.k:
            self.sampled.append(item)
        else:
            r = random.randint(0, self.cnt)
            if r < self.k:
                self.sampled[r] = item

        self.cnt += 1

    def counting(self, count):
        for i in self.sampled:
            count[i] += 1
        return count

    def reset(self):
        self.cnt = 0
        self.sampled = []

class ReservoirWithReplacement:
    def __init__(self, size):
        self.size = size
        self.reservoir = Reservoir(1)
        self.sampled = []

    def sampling(self):
        for k in range(self.size):
            for j in range(1000):
                self.reservoir.put(j)

            self.sampled.append(self.reservoir.sampled[0])
            self.reservoir.reset()
        return self.sampled

    def counting(self, count):
        for i in self.sampled:
            count[i] += 1
        return count

    def init_sampled(self):
        self.sampled = []


count = [0 for i in range(1000)]
count_replacement = [0 for i in range(1000)]
# 복원
reservoir_replace = ReservoirWithReplacement(100)
for i in range(10000):
    reservoir_replace.sampling()
    count_replacement = reservoir_replace.counting(count_replacement)
    reservoir_replace.init_sampled()

#비복원
reservoir = Reservoir(100)
for j in range(10000):
    for i in range(1000):
        reservoir.put(i)
    count = reservoir.counting(count)
    reservoir.reset()


x = np.arange(0, 1000)
plt.plot(x, np.array(count), label="reservoir")
plt.plot(x, np.array(count_replacement), label="reservoir_replacement")
plt.legend()
plt.show()



