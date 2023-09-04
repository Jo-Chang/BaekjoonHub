import sys
from itertools import combinations

fin = sys.stdin.readline
min_diff = 1e9

N = int(fin())
ability = [list(map(int, fin().split())) for _ in range(N)]

for team in combinations(range(1, N), N // 2 - 1):
    # 0을 team이 포함하게 계산할것
    team1 = list(team) + [0]
    team2 = [i for i in range(N) if i not in team1]
    team1_cnt = 0
    team2_cnt = 0
    
    for i in range(N // 2):
        for j in range(i + 1, N // 2):
            team1_cnt += ability[team1[i]][team1[j]] + ability[team1[j]][team1[i]]
            team2_cnt += ability[team2[i]][team2[j]] + ability[team2[j]][team2[i]]
    
    min_diff = min(abs(team1_cnt - team2_cnt), min_diff)
    if not min_diff:
        break
    
print(min_diff)