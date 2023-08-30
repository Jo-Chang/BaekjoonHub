import sys


fin = sys.stdin.readline
    

def solution():
    T = int(fin())
    
    for _ in range(T):
        answer = 0
        N = int(fin())
       
        P = [0] * (N if N > 5 else 5)
        P[0] = P[1] = P[2] = 1
        P[3] = P[4] = 2
        
        for i in range(5, N):
            P[i] = P[i - 1] + P[i - 5]
        
        answer = P[N - 1]
        print(answer)
        

if __name__ == "__main__":
    solution()