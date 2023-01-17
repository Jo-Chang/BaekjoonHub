N = int(input())

count = 1
temp_num = (N % 10) * 10 + (N // 10 + N % 10) % 10
while temp_num != N:
    count += 1
    temp_num = (temp_num % 10) * 10 + (temp_num // 10 + temp_num % 10) % 10

print(count)