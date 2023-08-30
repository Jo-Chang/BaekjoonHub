import sys


fin = sys.stdin.readline

MAX_N = 100
SEQ_P = [0] * MAX_N


def wave_sequence():
    global SEQ_P
    
    SEQ_P[0] = SEQ_P[1] = SEQ_P[2] = 1
    SEQ_P[3] = SEQ_P[4] = 2
    
    for i in range(5, MAX_N):
        SEQ_P[i] = SEQ_P[i - 1] + SEQ_P[i - 5]
    
def solution():
    global SEQ_P
    T = int(fin())
    
    wave_sequence()
    
    for _ in range(T):
        N = int(fin())
        print(SEQ_P[N - 1])
        

if __name__ == "__main__":
    solution()