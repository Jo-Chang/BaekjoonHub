import sys


def get_star_tree(n):
    return ["*" * m for m in range(1, n + 1)]


print(*get_star_tree(int(sys.stdin.readline())), sep="\n")