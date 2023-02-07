import sys


# input
people_num = int(sys.stdin.readline())

people_info_lst = []
for _ in range(people_num):
    people_info_lst.append(tuple(map(int, sys.stdin.readline().split())))
    
# print(people_info_lst)

# solution
def get_size_order(lst_):
    # Dictation removes duplication
    # Choose list
    ans_lst = []
    
    for i in range(len(lst_)):
        cnt = 1
        # Compare and count greater size people num
        for info in lst_:
            # Compare size
            if info[0] > lst_[i][0] and info[1] > lst_[i][1]:
                # Add greater size people num
                cnt += 1
        # Append count in list
        ans_lst.append(cnt)
        
    return ans_lst


# print
print(*get_size_order(people_info_lst))