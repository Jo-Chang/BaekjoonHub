num_order = list(map(int, input().split()))

while num_order != [1, 2, 3, 4, 5]:
    for i in range(len(num_order) - 1):
        if num_order[i] > num_order[i+1]:
            num_order[i], num_order[i+1] = num_order[i+1], num_order[i]
            print(*num_order)