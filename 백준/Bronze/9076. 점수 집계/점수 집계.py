import sys


JUDGE_NUM = 5

def is_KIN(lst_):
    sorted_lst = sorted(lst_)
    if sorted_lst[JUDGE_NUM - 2] - sorted_lst[1] > 3:
        return "KIN"
    else:
        return sum(sorted_lst) - sorted_lst[JUDGE_NUM - 1] - sorted_lst[0]


for T in range(int(sys.stdin.readline())):
    score_lst = list(map(int, sys.stdin.readline().split()))
    print(is_KIN(score_lst))