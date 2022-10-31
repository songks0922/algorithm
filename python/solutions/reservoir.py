import random

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

reservoir = Reservoir(15)

for i in range(1000):
    reservoir.put(i)
    print(reservoir.sampled)