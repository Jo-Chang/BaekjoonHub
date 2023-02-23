from collections import deque

def solution(priorities, location):
    answer = 0
    
    q = deque(priorities.copy())
    order = []
    idx = 0
    length = len(q)
    
    while True:
        while q[0] != max(q):
            q.rotate(-1)
            idx = (idx + 1) % length
            
        q[0] = 0
        order.append(idx)
        
        if len(order) == length:
            break
    
    answer = order.index(location) + 1
        
    return answer