import sys

fin = sys.stdin.readline


N, M = map(int, fin().split())
num_lst = list(map(int, fin().split()))

for i in range(1, N):
    num_lst[i] += num_lst[i - 1]
    
num_lst.append(0)
for _ in range(M):
    i, j = map(int, fin().split())
    print(num_lst[j - 1] - num_lst[i - 2])
    # if i > 1:
        # print(num_lst[j - 1] - num_lst[i - 2])
    # else:
        # print(num_lst[j - 1])