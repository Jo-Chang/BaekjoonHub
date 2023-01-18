for test_case in range(1, int(input()) + 1):
    repeat_num, word = input().split()
    repeat_num = int(repeat_num)
    for i_char in word:
        print(i_char * repeat_num, end="")
    print()