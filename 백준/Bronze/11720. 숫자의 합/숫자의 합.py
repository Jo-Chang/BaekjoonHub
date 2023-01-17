N = int(input())
num_string = input()
list_num = []
for ch in num_string:
    list_num.append(int(ch))

print(sum(list_num))