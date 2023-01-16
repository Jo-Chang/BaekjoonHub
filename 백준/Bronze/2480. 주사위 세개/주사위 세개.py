dict_num = [0 for i in range(6)]
dice_roll = list(map(int, input().split()))
for i in range(3):
    dict_num[dice_roll[i] - 1] += 1
    
for i in range(1, 7):
    if dict_num[i - 1] == 3:
        price = 10000 + i * 1000
        break
    elif dict_num[i - 1] == 2:
        price = 1000 + i * 100
        break
    elif dict_num[i - 1] == 1:
        price = i * 100
    else:
        pass
    
print(price)