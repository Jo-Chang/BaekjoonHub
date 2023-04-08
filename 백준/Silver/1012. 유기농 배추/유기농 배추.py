# 1012. 유기농 배추

import sys
from pprint import pprint

delta = [
    (0, 1),
    (0, -1),
    (1, 0),
    (-1, 0),
]

def check_valid(pos: tuple, m: int, n: int):
    if pos[0] < 0 or pos[0] >= n or pos[1] < 0 or pos[1] >= m:
        return False
    return True


test_case = int(input())

for tc in range(test_case):
    m, n, k = map(int, sys.stdin.readline().split())
    area = [[0] * m for _ in range(n)]
    answer = 0
    
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        area[y][x] = 1
        
    for i in range(n):
        for j in range(m):
            if not area[i][j] == 1:
                continue
            
            # pprint(area)
            answer += 1
            stack = [(i, j)]
            
            while stack:
                pos = stack.pop()
                for dx, dy in delta:
                    new_pos = (pos[0]+dy, pos[1]+dx)
                    if not check_valid(new_pos, m, n):
                        continue
                    
                    if area[new_pos[0]][new_pos[1]] == 1:
                        stack.append(new_pos)
                        area[new_pos[0]][new_pos[1]] = 2
    
    print(answer)