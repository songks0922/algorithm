
class Bucket:
    def __init__(self, start, end):
        self.start = start
        self.end = end

    def __repr__(self):
        return f"({self.start},{self.end}"

class DGIM:
    def __init__(self):
        self.bucket_tower = [[]]
        self.ts = 0

    def put(self, bit):

        if bit == 1:
            b = Bucket(self.ts, self.ts)
            self.bucket_tower[0].insert(0, Bucket(self.ts, self.ts))

            layer = 0
            while len(self.bucket_tower[layer]) > 2:
                if len(self.bucket_tower) <= layer+1:
                    self.bucket_tower.append([])
                b1 = self.bucket_tower[layer].pop()
                b2 = self.bucket_tower[layer].pop()

                b1.end = b2.end

                self.bucket_tower[layer+1].insert(0, b1)
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



dgim = DGIM()

for _ in range(20):
    dgim.put(1)
    print(dgim.bucket_tower)

for k in range(1, 10):
    print(k, dgim.count(k))