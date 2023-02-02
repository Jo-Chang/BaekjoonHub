import sys


#input
w_participants_lst = []
k_participants_lst = []

for _ in range(10):
    score_num = int(sys.stdin.readline())
    # Input Error
    if not (0 <= score_num <= 100):
        print("Wrong Input!")
        
    w_participants_lst.append(score_num)
    
for _ in range(10):
    score_num = int(sys.stdin.readline())
    # Input Error
    if not (0 <= score_num <= 100):
        print("Wrong Input!")
        
    k_participants_lst.append(score_num)


# solution
def high_3_sum(lst_):
    sorted_lst = sorted(lst_)
    
    return sum(sorted_lst[-3:])


# print
print(high_3_sum(w_participants_lst), high_3_sum(k_participants_lst))