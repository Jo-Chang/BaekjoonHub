# 1927. 최소 힙

import sys
import heapq

# sys.stdin = open("1927.txt")


num_lst = []
heapq.heapify(num_lst)
for T in range(int(sys.stdin.readline())):
    num = int(sys.stdin.readline())
    if num == 0:
        try:
            print(heapq.heappop(num_lst))
        except:
            print(0)
    else:
        heapq.heappush(num_lst, num)