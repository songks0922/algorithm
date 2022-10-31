import numpy as np

w1 = np.array([-0.7, 0.9, 0.8])
x = np.array([1, 1, 0])
h1 = -1 if np.dot(w1, x) < 0 else 1
print(f'h1 = {h1}')
w2 = np.array([-0.7, 0.9, 0.8])
h2 = -1 if np.dot(x, w2) < 0 else 1
print(f'h2 = {h2}')
hide = np.array([1, h1, h2])
l = np.array([-1, 1, 1])

print(f'result = {np.dot(hide, l)}')