import sys


def get_closest_sum(n, lst_):
    lst_2 = []
    for i in range(len(lst_)):
        for j in range(i+1, len(lst_)):
            for k in range(j+1, len(lst_)):
                num_sum = lst_[i] + lst_[j] + lst_[k]
                if num_sum <= n:
                    lst_2.append(num_sum)
                    # print(lst_[i], lst_[j], lst_[k], num_sum)
                    
    return max(lst_2)
    


n_num, m_num = map(int, sys.stdin.readline().split())
card_lst = list(map(int, sys.stdin.readline().split()))

print(get_closest_sum(m_num, card_lst))