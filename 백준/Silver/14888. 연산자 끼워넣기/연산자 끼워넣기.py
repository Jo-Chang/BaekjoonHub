import sys


fin = sys.stdin.readline
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
    
    
if __name__ == "__main__":
    solution()