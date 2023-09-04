import sys
from itertools import combinations

fin = sys.stdin.readline
min_diff = 1e9

N = int(fin())
ability = [list(map(int, fin().split())) for _ in range(N)]

for team in combinations(range(1, N), N // 2 - 1):
    # 0을 team이 포함하게 계산할것
    team1 = 0
    team2 = 0
    
    for i in range(N):
        for j in range(N):
            if (i in team or i == 0) and (j in team or j == 0):
                team1 += ability[i][j]
            elif not (i in team or i == 0) and not (j in team or j == 0):
                team2 += ability[i][j]
    
    diff = abs(team1 - team2)
    min_diff = diff if diff < min_diff else min_diff
    
print(min_diff)