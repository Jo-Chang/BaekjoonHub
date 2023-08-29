from sys import stdin, exit
from math import comb


MOD = 15746


# Time Over
def solution():
    answer = 0
    N = int(stdin.readline())
    
    max_zero = N // 2
    while max_zero >= 0:
        one = N - 2 * max_zero
        answer += comb(one + max_zero, one)
        max_zero -= 1
    
    print(answer % MOD)


def solution_fibonacci():
    answer = 0    
    N = int(stdin.readline())
    
    if N > 1:
        f1 = 1
        f2 = 2
        while N > 2:
            # fibo[i] = (fibo[i - 1] * 2 + fibo[i - 2] * 2) // 2
            # 양 끝에 1과 00을 추가하므로 * 2
            # 각 양 끝에 추가된 수열이 겹치므로 // 2
            f1, f2 = f2 % MOD, (f1 + f2) % MOD
            N -= 1
        answer = f2
    elif N == 1:
        answer = 1
    else:   # Wrong Input
        exit()
        
    print(answer % MOD)

if __name__ == "__main__":
    # solution()
    solution_fibonacci()
    