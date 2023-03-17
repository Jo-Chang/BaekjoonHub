# 15656. N과 M (7)

n, m = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst = sorted(num_lst)
comb_lst = []

def my_comb_recursion():
    if len(comb_lst) == m:
        print(' '.join(map(str, comb_lst)))
        return
    
    for num in num_lst:
        comb_lst.append(num)
        my_comb_recursion()
        comb_lst.pop()

my_comb_recursion()