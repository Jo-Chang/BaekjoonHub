# 15651. N과 M (3)

n, m = map(int, input().split())
answer = []

def my_comb_recursion(n: int, k: int, lst: list) -> None :
    if k == 0:
        answer.append(tuple(lst))
        lst.pop()
        return 
    
    for i in range(1, n+1):
        lst.append(i)
        my_comb_recursion(n, k-1, lst)
        
    if k != m:
        lst.pop()
    
my_comb_recursion(n, m, [])

for lst in answer:
    print(*lst)