total_num = int(input()) * int(input()) * int(input())
num_dict = {}

while total_num > 0:
    temp_num = total_num % 10
    num_dict[temp_num] = num_dict.get(temp_num, 0) + 1
    total_num //= 10

for i in range(10):
    num_dict[i] = num_dict.get(i, 0)
num_dict = dict(sorted(num_dict.items()))
print(*num_dict.values(), sep="\n")