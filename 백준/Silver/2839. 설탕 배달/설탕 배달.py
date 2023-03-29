# 2839. 설탕 배달

n = int(input())
for i in range(n//5, -1, -1):
    temp = n
    cnt = 0
    temp -= 5 * i
    if temp % 3 == 0:
        cnt = i + temp // 3
        print(cnt)
        break
else:
    print(-1)