# 15651. N과 M (3)

n, m = map(int, input().split())

def my_comb_recursion(n: int, k: int, lst: list):  
    if k == 0:
        print(*lst)
        lst.pop()
        return 
    for i in range(1, n+1):
        lst.append(i)
        my_comb_recursion(n, k-1, lst)
    if k != m: lst.pop()
    
my_comb_recursion(n, m, [])