import sys


fin = sys.stdin.readline

N, K = map(int, fin().split())
S = list(map(int, fin().split()))

for i in range(1, N):
    S[i] += S[i - 1]

S.append(0)
max_sum = -1e9
for i in range(N - K + 1):
    num_sum = S[i + K - 1] - S[i - 1]
    max_sum = num_sum if num_sum > max_sum else max_sum

print(max_sum)