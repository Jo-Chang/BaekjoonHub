import sys

PROBLEM_NUM = 20001
# sys.stdin = open(f"{PROBLEM_NUM}.txt", encoding="UTF8")

#####

cmd_lst = ["고무오리 디버깅 시작", "문제", "고무오리", "고무오리 디버깅 끝"]

def debugging_end(lst_):
    if lst_:
        print("힝구")
    else:
        print("고무오리야 사랑해")


if sys.stdin.readline().strip() != cmd_lst[0]:
    print("Wrong Input!")
else:
    input_cmd_lst = []
    while True:
        command = sys.stdin.readline().strip()
        if command == cmd_lst[3]:
            debugging_end(input_cmd_lst)
            break
        elif command == cmd_lst[1]:
            input_cmd_lst.append(command)
        elif command == cmd_lst[2]:
            if input_cmd_lst:
                input_cmd_lst.pop()
            else:
                input_cmd_lst.append(cmd_lst[1])
                input_cmd_lst.append(cmd_lst[1])
