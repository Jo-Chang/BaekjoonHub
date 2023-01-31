import sys


def representational_num(dict_):
    max_tuple = max(dict_.items(), key=lambda x: x[1])
    mean_ = 0
    for mem in dict_.items():
        mean_ += mem[0] * mem[1]
    mean_ //= sum(dict_.values())
    
    return (mean_, max_tuple[0])


num_dict = {}
for _ in range(10):
    num = int(sys.stdin.readline())
    num_dict[num] = num_dict.get(num, 0) + 1
    
print(*representational_num(num_dict), sep="\n")