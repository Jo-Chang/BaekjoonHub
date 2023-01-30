import sys

MAX_POS = 100

def sol_2d(lst_2d):
    ans = [[0] * MAX_POS for _ in range(MAX_POS)]
    for lst_ in lst_2d:
        for x in range(lst_[0], lst_[2]):
            for y in range(lst_[1], lst_[3]):
                ans[x][y] = 1
    
    # print("y\n")
    # for _ in range(9, -1, -1):
    #     print(f"{_} | ", end=" ")
    #     for __ in range(10):
    #         print(ans[__][_], end=" ")
    #     print()
    # print("  " + "-" * 22)
    # print(f"    ", *[m for m in range(10)], " x")
        
    return sum([sum(lst_) for lst_ in ans])

def sol_set(lst_2d):
    ans = set()
    for lst_ in lst_2d:
        for x in range(lst_[0], lst_[2]):
            for y in range(lst_[1], lst_[3]):
                ans.add((x, y))
                
    return len(ans)

# input
pos_lst2 = []
for _ in range(4):
    pos_lst2.append(list(map(int, sys.stdin.readline().split())))

# print
# print(sol_2d(pos_lst2))
print(sol_set(pos_lst2))