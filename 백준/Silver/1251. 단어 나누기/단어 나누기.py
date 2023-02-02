import sys
from itertools import combinations

#input
word = sys.stdin.readline().strip()
if not word.islower():
    sys.exit("Input is not correct")


# solution
def get_split_reversed_word(word):
    lst_ = []
    split_lst = list(combinations(range(len(word) - 1), 2))
    
    for cut1, cut2 in split_lst:
        lst_.append(word[cut1::-1] + word[cut2:cut1:-1] + word[-1:cut2:-1])
    
    return min(lst_)


# print
print(get_split_reversed_word(word))