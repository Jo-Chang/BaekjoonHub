import sys


def get_winner(lst_):
    max_idx = 0
    max_sum = sum(lst_[max_idx])
    for idx in range(1, 5):
        temp_sum = sum(lst_[idx])
        if  temp_sum > max_sum:
            max_sum = temp_sum
            max_idx = idx
            
    return max_idx + 1, max_sum


# input
score_lst = []
for _ in range(5):
    score_lst.append(list(map(int, sys.stdin.readline().split())))

# print
print(*get_winner(score_lst))