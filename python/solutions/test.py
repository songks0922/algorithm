import random
import numpy as np


# generate random numbers ranging from 0 to 5 size 100 to 2 dimentions np array function
def generate_random_numbers():
    return np.random.randint(0, 5, (100, 100))

numbers = generate_random_numbers()
print(len(numbers[0]))