import sys


def my_sort(x):
    return len(x), x
    
def get_my_dict(lst_):
    return sorted(lst_, key=my_sort)


word_lst = set([])
for T in range(int(sys.stdin.readline())):
    word_lst.add(sys.stdin.readline().strip())
    
print(*get_my_dict(word_lst), sep="\n")