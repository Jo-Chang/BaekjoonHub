def solution(absolutes, signs):
    answer = 0
    
    for idx, num in enumerate(absolutes):
        answer += num if signs[idx] else -num
        
    return answer