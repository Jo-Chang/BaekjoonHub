import sys


def get_move_box_num(lst2_):
    ans = 0
    y_len = len(lst2_)
    x_len = len(lst2_[0])
    for i in range(x_len):
        cnt = 0
        for j in range(y_len-1, -1, -1):
            if lst2_[j][i] == 1:
                ans += (y_len - 1 - cnt) - j
                cnt += 1
        
    return ans
    

for T in range(int(sys.stdin.readline())):
    n_num, m_num = map(int, sys.stdin.readline().split())
    map_lst2 = []
    for _ in range(n_num):
        map_lst2.append(list(map(int, sys.stdin.readline().split())))
    print(get_move_box_num(map_lst2))