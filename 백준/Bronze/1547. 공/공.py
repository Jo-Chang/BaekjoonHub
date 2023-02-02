import sys


#input
num_pair_lst = []
for T in range(int(sys.stdin.readline())):
    x_num, y_num = map(int, sys.stdin.readline().split())
    num_pair_lst.append((x_num, y_num))

# solution
def find_ball(lst_):
    ball = 1
    for a, b in lst_:
        if a == ball:
            ball = b
            continue
        elif b == ball:
            ball = a

    if ball not in [1, 2, 3]:
        return -1

    return ball

# print
print(find_ball(num_pair_lst))
# print(num_pair_lst)