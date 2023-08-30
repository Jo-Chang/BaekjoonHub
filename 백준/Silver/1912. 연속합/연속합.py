import sys


fin = sys.stdin.readline
MAX_NUM = 1000
MIN_NUM = -1000


def solution():
    n = int(fin())
    seq_num = list(map(int, fin().rstrip().split()))
    dp = [MIN_NUM] * n
    
    dp[0] = seq_num[0]
    for i in range(1, n):
        dp[i] = seq_num[i] + (0 if dp[i - 1] < 0 else dp[i - 1])
    
    print(max(dp))
    
    
if __name__ == "__main__":
    solution()