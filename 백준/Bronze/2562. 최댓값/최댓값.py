dict_var = {}

for order in range(1, 10):
    num = int(input())
    dict_var[num] = order

result = max(dict_var.items())
print(result[0], result[1], sep ="\n")