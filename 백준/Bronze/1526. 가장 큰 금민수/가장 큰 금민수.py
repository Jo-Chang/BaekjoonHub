import sys


def is_KEAUNMIN_num(num):
    temp_num = num
    while temp_num > 0:
        if temp_num % 10 != 4 and temp_num % 10 != 7:
            return False
        temp_num //= 10
        
    return True
    
def get_max_KEUNMIN_num(num):
    while not is_KEAUNMIN_num(num):
        num -= 1
        
    return num


print(get_max_KEUNMIN_num(int(sys.stdin.readline())))