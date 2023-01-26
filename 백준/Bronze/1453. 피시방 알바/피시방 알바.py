import sys

def get_rejected(lst_):
    cnt = 0
    
    lst_2 = []
    for i in lst_:
        if i in lst_2:
            cnt += 1
        else:
            lst_2.append(i)
    
    return cnt

people_num = int(sys.stdin.readline())
num_lst = list(map(int, sys.stdin.readline().split()))
print(get_rejected(num_lst))