import sys

# input & print
n_num = int(sys.stdin.readline().strip())
for _ in range(n_num):
    zero_cnt, one_cnt = 0, 0
    input_num = int(sys.stdin.readline().strip())
    
    # Time measure start
    # start = time.time()
    
    idx = 0
    cnt_lst = []
    # only count '0' and '1'
    for idx in range(input_num + 1):
        if idx == 0:
            cnt_lst.append([1, 0])
        elif idx == 1:
            cnt_lst.append([0, 1])
        else:
            cnt_lst.append([cnt_lst[idx-1][0] + cnt_lst[idx-2][0], cnt_lst[idx-1][1] + cnt_lst[idx-2][1]])
        
    print(*cnt_lst.pop())
    
    # Time measure
    # end = time.time()
    # print(datetime.timedelta(seconds = end - start))