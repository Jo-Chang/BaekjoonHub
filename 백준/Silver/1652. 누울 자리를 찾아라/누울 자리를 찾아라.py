import sys


def get_positions_num(lst_):
    ans_row, ans_col = 0, 0
    len_ = len(lst_)
    
    
    for i in range(len_):
        accumulate1 = 0
        accumulate2 = 0
        for j in range(len_):
            # width count
            if lst_[i][j] == "X":
                if accumulate1 > 1:
                    ans_row += 1
                accumulate1 = 0
            else:
                accumulate1 += 1
                
            if lst_[j][i] == "X":
                if accumulate2 > 1:
                    ans_col += 1
                accumulate2 = 0
            else:
                accumulate2 += 1
                
        if accumulate1 > 1:
            ans_row += 1
        if accumulate2 > 1:
            ans_col += 1
    
    return ans_row, ans_col


position_lst = []
for T in range(int(sys.stdin.readline())):
    position_lst.append(sys.stdin.readline().strip())
    
print(*get_positions_num(position_lst))