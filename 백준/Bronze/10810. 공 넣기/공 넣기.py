import sys

n, m = map(int, input().split())
arr = [0 for _ in range(n)]
for _ in range(m):
    a, b, num = map(int, input().split())
    for i in range(a, b + 1):
        arr[i - 1] = num
        
print(*arr)