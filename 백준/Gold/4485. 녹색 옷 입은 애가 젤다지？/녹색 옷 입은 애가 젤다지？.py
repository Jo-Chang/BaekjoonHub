# 4485. 녹색 옷 입은 애가 젤다지?

import sys
import heapq

test_case = 0
DELTA = [(0, 1), (0, -1), (1, 0), (-1, 0)]
VISITED = -1

while True:
    test_case += 1
    N = int(sys.stdin.readline())
    if N == 0:
        break
    
    map_ = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    cost = [[int(1e9)] * N for _ in range(N)]

    q = list()
    heapq.heappush(q, (map_[0][0], (0, 0)))
    
    while q:
        cur_cost, cur_pos = heapq.heappop(q)
        # print(f'cur : {cur_cost}, {cur_pos}')
        
        if cur_pos[0] == N-1 and cur_pos[1] == N-1:
            break
        
        # if cur_cost > cost[cur_pos[0]][cur_pos[1]]:
        #     continue
        
        map_[cur_pos[0]][cur_pos[1]] = VISITED
        
        for dy, dx in DELTA:
            new_pos = (cur_pos[0]+dy, cur_pos[1]+dx)
            if not (0 <= new_pos[0] < N and 0 <= new_pos[1] < N):
                continue
            new_cost =  map_[new_pos[0]][new_pos[1]] + cur_cost
            if map_[new_pos[0]][new_pos[1]] != VISITED and cost[new_pos[0]][new_pos[1]] > new_cost:
                cost[new_pos[0]][new_pos[1]] = new_cost
                heapq.heappush(q, (cost[new_pos[0]][new_pos[1]], new_pos))
        
    answer = cost[N-1][N-1]

    print(f'Problem {test_case}: {answer}')