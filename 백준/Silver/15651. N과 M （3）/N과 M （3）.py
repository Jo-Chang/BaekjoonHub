# 15651. N과 M (3)

n, m = map(int, input().split())
lst = []

def my_comb_recursion():  
    if len(lst) == m:
        print(" ".join(map(str, lst)))
        return 
    for i in range(1, n+1):
        lst.append(i)
        my_comb_recursion()
        lst.pop()
    
my_comb_recursion()