A, B = map(int, input().split())

B = B % 3 + 1
if A == B:
    print("A")
else:
    print("B")
    