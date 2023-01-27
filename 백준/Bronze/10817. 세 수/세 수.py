import sys
import heapq


def get_second_max(lst_):
    heap_ = lst_
    heapq.heapify(heap_)
    heapq.heappop(heap_)
    return heapq.heappop(heap_)


print(get_second_max(list(map(int, sys.stdin.readline().split()))))