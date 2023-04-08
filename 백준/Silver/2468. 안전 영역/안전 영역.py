# 2468. 안전 영역

import sys
# import pprint
sys.setrecursionlimit(10 ** 4)

delta = [
    (1, 0),
    (-1, 0),
    (0, 1),
    (0, -1)
]

def check_valid(pos: tuple, n: int):
    # global area_temp
    if 0 <= pos[0] < n and 0 <= pos[1] < n and area_temp[pos[0]][pos[1]] > 0:
        return True
    return False


def dfs(pos: tuple):
    # global delta, area_temp
    for dx, dy in delta:
        new_pos = (pos[0]+dy, pos[1]+dx)
        if check_valid(new_pos, n):
            area_temp[new_pos[0]][new_pos[1]] = 0
            dfs(new_pos)


n = int(input())
area = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# pprint.pprint(area)
heights = set(sum(area, []))

answer = 1
for height in heights:
    cnt = 0
    area_temp = [[i - height for i in area[j]] for j in range(n)]
    for i in range(n):
        for j in range(n):
            if area_temp[i][j] <= 0:
                continue
            cnt += 1
            dfs((i, j))
    
    answer = cnt if cnt > answer else answer
    
print(answer)
        