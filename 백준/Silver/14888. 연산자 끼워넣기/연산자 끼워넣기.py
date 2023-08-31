import sys


fin = sys.stdin.readline
max_num = -1000000000
min_num = 1000000000
result = list()

    
def solution():
    global result
    
    cal_dict = {
        '+': 0,
        '-': 0,
        '*': 0,
        '/': 0
    }
    
    def calculate(idx: int, _dict: dict, calculating: int):
        if not sum(_dict.values()):
            result.append(calculating)
        else:
            for key, val in _dict.items():
                if val:
                    num = num_lst[idx]
                    if key == '+':
                        new_cal = calculating + num
                    elif key == '-':
                        new_cal = calculating - num
                    elif key == '*':
                        new_cal = calculating * num
                    elif key == '/':
                        sign = 1
                        if calculating < 0:
                            calculating *= -1
                            sign = -1
                        new_cal = calculating // num * sign
                    
                    new_dict = _dict.copy()
                    new_dict[key] -= 1
                    calculate(idx+1, new_dict, new_cal)
    
    N = int(fin())
    num_lst = list(map(int, fin().rstrip().split()))
    cal_dict['+'], cal_dict['-'], cal_dict['*'], cal_dict['/'] = map(
        int, fin().rstrip().split())
                    
    calculate(1, cal_dict, num_lst[0])
    
    print(max(result), min(result), sep='\n')


# Faster
def solution2():
    def calculate(idx: int, plus: int, minus: int, multi: int, div: int, calculating: int):
        global max_num, min_num
        
        if idx == N:
            max_num = calculating if max_num < calculating else max_num
            min_num = calculating if min_num > calculating else min_num
        else:
            if plus:
                calculate(idx + 1, plus - 1, minus, multi, div, calculating + num_lst[idx])
            if minus:
                calculate(idx + 1, plus, minus - 1, multi, div, calculating - num_lst[idx])
            if multi:
                calculate(idx + 1, plus, minus, multi - 1, div, calculating * num_lst[idx])
            if div:
                calculate(idx + 1, plus, minus, multi, div - 1, int(calculating / num_lst[idx]))

    N = int(fin())
    num_lst = list(map(int, fin().rstrip().split()))
    cal_lst = list(map(int, fin().rstrip().split()))
    
    calculate(1, cal_lst[0], cal_lst[1], cal_lst[2], cal_lst[3], num_lst[0])
    
    print(max_num, min_num, sep='\n')
    
    
if __name__ == "__main__":
    # solution()
    solution2()