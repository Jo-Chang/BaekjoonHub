import sys


def get_changes(num):
    lst = []
    
    lst.append(num // 25)
    num %= 25
    lst.append(num // 10)
    num %= 10
    lst.append(num // 5)
    num %= 5
    lst.append(num)
    
    return lst


for T in range(int(sys.stdin.readline())):
    print(*get_changes(int(sys.stdin.readline())))