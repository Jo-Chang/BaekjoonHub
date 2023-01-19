log_dict = {} 
for i_num in range(int(input())):
    name, log = input().split()
    log_dict[name] = log

left_name = [key for key in log_dict.keys() if log_dict[key] == "enter"]
print(*sorted(left_name, reverse=True), sep="\n")