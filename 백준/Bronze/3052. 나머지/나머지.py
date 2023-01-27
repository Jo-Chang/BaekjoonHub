import sys


def get_mod42_set(lst_):
    return set([mem%42 for mem in lst_])


nums = []
for T in range(10):
    nums.append(int(sys.stdin.readline()))
    
print(len(get_mod42_set(nums)))