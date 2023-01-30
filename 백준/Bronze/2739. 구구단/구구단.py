import sys


def get_multiplication_table(n):
    return [f"{n} * {m} = {n * m}" for m in range(1, 10)]


print(*get_multiplication_table(int(sys.stdin.readline())), sep="\n")