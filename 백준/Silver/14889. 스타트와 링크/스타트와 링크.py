import sys

fin = sys.stdin.readline
min_diff = 1e9

N = int(fin())
ability = [list(map(int, fin().rstrip().split())) for _ in range(N)]

def solution1():
    from itertools import combinations
    global min_diff
    
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


def solution2():
    team1 = [0]
    
    def set_team(depth: int, idx: int):
        global min_diff
        
        if depth == N // 2:
            team2 = [i for i in range(1, N) if i not in team1]
            team1_cnt = 0
            team2_cnt = 0
            for i in range(N // 2):
                for j in range(i+1, N//2):
                    team1_cnt += ability[team1[i]][team1[j]] + ability[team1[j]][team1[i]]
                    team2_cnt += ability[team2[i]][team2[j]] + ability[team2[j]][team2[i]]
            min_diff = min(abs(team1_cnt - team2_cnt), min_diff)
            if min_diff == 0:
                return
            
        else:
            for i in range(idx, N):
                team1.append(i)
                set_team(depth + 1, i + 1)
                team1.pop()
    
    set_team(1, 1)

def solution3():
    team1 = [0]
    team2 = list()
    
    def set_team(depth: int, res: int):
        global min_diff
        
        if depth == N:
            min_diff = min(abs(res), min_diff)
            return
            
        if min_diff == 0:
            return
        
        if len(team1) < N // 2:
            new_res = res
            for mem in team1:
                new_res += ability[depth][mem] + ability[mem][depth]
            team1.append(depth)
            set_team(depth + 1, new_res)
            team1.pop()
                
        if len(team2) < N // 2:
            new_res = res
            for mem in team2:
                new_res -= ability[depth][mem] + ability[mem][depth]
            team2.append(depth)
            set_team(depth + 1, new_res)
            team2.pop()
    
    set_team(1, 0)
    
# Fastest
def solution4():
    from itertools import combinations
    global min_diff
    
    new_abi = [sum(i) + sum(j) for i, j in zip(ability, zip(*ability))]
    total_stat = sum(new_abi) // 2
    
    for comb in combinations(new_abi, N // 2):
        min_diff = min(abs(total_stat - sum(comb)), min_diff)
        
# solution1()
# solution2()
# solution3()
solution4()
print(min_diff)