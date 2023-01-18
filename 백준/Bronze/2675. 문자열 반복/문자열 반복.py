for test_case in range(1, int(input()) + 1):
    repeat_num, word = input().split()
    repeat_num = int(repeat_num)
    print(*[i_char*repeat_num for i_char in word], sep="")