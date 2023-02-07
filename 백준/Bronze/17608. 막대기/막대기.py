import sys


# input
n_num = int(sys.stdin.readline())

num_lst = []
for _ in range(n_num):
    num_lst.append(int(sys.stdin.readline()))
    

# solution
def get_stick_num(lst_):
    max_height = 0
    cnt = 0
    
    for stick in lst_[::-1]:
        if stick > max_height:
            max_height = stick
            cnt += 1
            
    return cnt


# print
print(get_stick_num(num_lst))