import sys


#input
sequence_num = int(sys.stdin.readline())
sequence_lst = list(map(int, sys.stdin.readline().split()))


# solution
def get_increase_area(lst_):
    ans = 0
    len_ = len(lst_)
    
    cnt = 0
    for i in range(1, len_):
        if lst_[i - 1] < lst_[i]:
            cnt += 1
        else:
            distance = lst_[i - 1] - lst_[i - 1 - cnt]
            ans = distance if distance > ans else ans
            cnt = 0
    
    distance = lst_[len_ - 1] - lst_[len_ - 1 - cnt]
    ans = distance if distance > ans else ans
                
    return ans


# print
print(get_increase_area(sequence_lst))