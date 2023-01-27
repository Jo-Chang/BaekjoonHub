import sys


def get_symmetric_diff_num(a, b):
    return len([ele for ele in a if ele not in b] + [ele for ele in b if ele not in a])


a_num, b_num = map(int, sys.stdin.readline().split())

a_set = set(list(map(int, sys.stdin.readline().split())))
b_set = set(list(map(int, sys.stdin.readline().split())))

print(get_symmetric_diff_num(a_set, b_set))