import sys


def get_time(h, m, t):
    ans_h = (h + (m + t) // 60) % 24
    ans_m = (m + t) % 60
    
    return ans_h, ans_m


hour_num, minute_num = map(int, sys.stdin.readline().split())
time_num = int(sys.stdin.readline())
print(*get_time(hour_num, minute_num, time_num))