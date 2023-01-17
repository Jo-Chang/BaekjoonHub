N = int(input())

list_num = []
for i in range(N):
    list_num.append(int(input()))

# list_num = sorted(list_num)
list_num.sort()
print(*list_num, sep="\n")