import sys


def new_product(lst_):
    sum1 = sum([int(_) for _ in lst_[0]])
    sum2 = sum([int(_) for _ in lst_[1]])
    
    return sum1 * sum2


print(new_product(sys.stdin.readline().split()))