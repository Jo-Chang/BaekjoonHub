# 2167. 2차원 배열의 합

import sys

input = sys.stdin.readline

N, M = map(int, input().split())

lst = [list(map(int, input().split())) for _ in range(N)]

K = int(input())

answer = list()
for _ in range(K):
    cnt = 0
    i, j, x, y = map(int, input().split())
    
    cnt = sum([sum(lst[l][j-1:y]) for l in range(i-1, x)])
    
    answer.append(cnt)
            
print('\n'.join(map(str, answer)))