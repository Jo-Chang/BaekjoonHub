num_lst = []
for idx in range(1, int(input()) + 1):
    num = int(input())
    if num == 0:
        num_lst.pop()
    else:
        num_lst.append(num)

print(sum(num_lst))