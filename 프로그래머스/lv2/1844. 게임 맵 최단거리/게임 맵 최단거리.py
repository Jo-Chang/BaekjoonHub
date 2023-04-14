from collections import deque

DELTA = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def solution(maps):
    answer = 0
    size = (len(maps), len(maps[0]))
    deq = deque([(0,0)])
    
    while deq:
        pos = deq.popleft()
        for dy, dx in DELTA:
            new_pos = (pos[0]+dy, pos[1]+dx)
            if not check_valid(new_pos, size):
                continue
            if maps[new_pos[0]][new_pos[1]] == 1:
                deq.append(new_pos)
                maps[new_pos[0]][new_pos[1]] = maps[pos[0]][pos[1]] + 1
    
    answer = maps[size[0] - 1][size[1] - 1]
    if answer == 1:
        answer = -1
    return answer


def check_valid(new_pos:tuple, size: tuple):
    if 0 <= new_pos[0] < size[0] and 0 <= new_pos[1] < size[1]:
        return True
    return False