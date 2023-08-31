import sys


fin = sys.stdin.readline

N = int(fin())
rgb_lst = [list(map(int, fin().split())) for _ in range(N)]
dp = [[0] * 3 for _ in range(N)]

for i in range(3):
    dp[0][i] = rgb_lst[0][i]

for i in range(1, N):
    dp[i][0] = min(dp[i-1][1] + rgb_lst[i][0], dp[i-1][2] + rgb_lst[i][0])
    dp[i][1] = min(dp[i-1][0] + rgb_lst[i][1], dp[i-1][2] + rgb_lst[i][1])
    dp[i][2] = min(dp[i-1][0] + rgb_lst[i][2], dp[i-1][1] + rgb_lst[i][2])
    
print(min(dp[N - 1]))