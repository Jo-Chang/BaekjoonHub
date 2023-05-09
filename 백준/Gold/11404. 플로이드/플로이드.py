# 11404. 플로이드

import sys
import heapq
# sys.stdin = open("input.txt", "r")
input = sys.stdin.readline
inf = int(1e9)

n = int(input())
m = int(input())

G = [[] for _ in range(n)]
answer = [[inf] * n for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    G[a-1].append([b-1, c])
    
def dijkstra(start: int):
    global G, n, answer
    q = [[0, start]]
    
    while q:
        cur_cost, cur = heapq.heappop(q)
        if cur_cost > answer[start][cur]:
            continue
        
        for adj, adj_cost in G[cur]:
            cost = cur_cost + adj_cost
            if answer[start][adj] > cost:
                answer[start][adj] = cost
                heapq.heappush(q, [cost, adj])
        

for idx in range(n):
    dijkstra(idx)
    for i, num in enumerate(answer[idx]):
        if num == inf:
            answer[idx][i] = 0
    answer[idx][idx] = 0
    print(' '.join(map(str, answer[idx])))