list_num = []
for i in range(7):
    num = int(input())
    if num % 2 != 0:
        list_num.append(num)
    
if len(list_num) == 0:
    print(-1)
else:
    print(sum(list_num), min(list_num), sep="\n")