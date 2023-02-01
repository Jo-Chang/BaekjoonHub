import sys

    
def get_666_num(num):
    ans = 666
    cnt = 0
    while True:
        ans = str(ans)
        if "666" in ans:
            cnt += 1
            if cnt == num:
                return int(ans)
        ans = int(ans) + 1


print(get_666_num(int(sys.stdin.readline())))