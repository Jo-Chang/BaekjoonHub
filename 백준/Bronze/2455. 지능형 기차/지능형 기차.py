import sys


STATION_NUM = 4

# input
num_people_lst = []
for _ in range(STATION_NUM):
    get_off_num, get_on_num = map(int, sys.stdin.readline().split())
    num_people_lst.append((get_off_num, get_on_num))    # tuple in list
    

# solution
def get_max_people_num(lst_):
    num = 0
    max_num = 0
    
    for off, on in lst_:
        num += on - off
        if num > max_num:   
            max_num = num   # Renew maximun number of 'people in train'
            
    return max_num    


# print
print(get_max_people_num(num_people_lst))