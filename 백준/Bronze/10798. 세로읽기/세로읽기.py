import sys


def print_transpose(lst2_):
    ans = ""
    
    for i in range(max([len(word) for word in lst2_])):
        for j in range(5):
            if i < len(lst2_[j]):
                ans += lst2_[j][i]
                
    print(ans)


word_lst2 = []
for _ in range(5):
    word_lst2.append(sys.stdin.readline().strip())
    
print_transpose(word_lst2)