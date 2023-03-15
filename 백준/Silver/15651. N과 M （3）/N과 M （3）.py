# 15651. N과 M (3)

import sys

n, m = map(int, sys.stdin.readline().split())
lst = []
visited = [False] * m

def my_comb_recursion():  
    if len(lst) == m:
        # print(*lst)
        sys.stdout.write(' '.join(map(str, lst))+'\n')
        return 
    
    for i in range(1, n+1):
        lst.append(i)
        my_comb_recursion()
        lst.pop()
    
my_comb_recursion()