import sys
fin = sys.stdin.readline

n = int(fin())
s = [list(map(int, fin().rstrip().split())) for _ in range(n)]
dp = [[0] * i for i in range(1, n + 1)]

dp[0][0] = s[0][0]
for i in range(1, n):
    for j in range(i + 1):
        if 0 < j < i:
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + s[i][j]
        elif j == 0:
            dp[i][j] = dp[i - 1][j] + s[i][j]
        else:   # j == i
            dp[i][j] = dp[i - 1][j - 1] + s[i][j]
            
print(max(dp[n - 1]))