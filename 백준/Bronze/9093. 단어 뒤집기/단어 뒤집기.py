for test_case in range(1, int(input()) + 1):
    words = input().split()
    for word in words:
        print(word[::-1], end= " ")
    print()