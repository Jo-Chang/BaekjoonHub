# 15651. N과 M (3)

n, m = map(int, input().split())
lst = []

def my_comb_recursion(n: int, k: int):  
    if k == 0:
        print(*lst)
        return 
    for i in range(1, n+1):
        lst.append(i)
        my_comb_recursion(n, k-1)
        lst.pop()
    
my_comb_recursion(n, m)