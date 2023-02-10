import sys


# input
n_num = int(sys.stdin.readline())


# solution
construct_num = 0
while construct_num < n_num:
    # Check construct_num is constructor of n_num
    sum_num = construct_num
    for single_digit in str(construct_num):
        sum_num += "0123456789".index(single_digit)
    
    # Find min constructor
    if sum_num == n_num:
        break
    
    construct_num += 1
else:
    construct_num = 0
    
    
# print
print(construct_num)