import sys


fin = sys.stdin.readline

MAX_N = 100
seq_p = [0] * MAX_N


def wave_sequence():
    global seq_p
    seq_p[0] = seq_p[1] = seq_p[2] = 1
    seq_p[3] = seq_p[4] = 2
    
    for i in range(5, MAX_N):
        seq_p[i] = seq_p[i - 1] + seq_p[i - 5]
    
def solution():
    global seq_p
    T = int(fin())
    
    wave_sequence()
    
    for _ in range(T):
        N = int(fin())
        print(seq_p[N - 1])
        

if __name__ == "__main__":
    solution()