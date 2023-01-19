dial_dict = {
    "A": 2, "B": 2, "C": 2,
    "D": 3, "E": 3, "F": 3,
    "G": 4, "H": 4, "I": 4,
    "J": 5, "K": 5, "L": 5,
    "M": 6, "N": 6, "O": 6,
    "P": 7, "Q": 7, "R": 7, "S": 7,
    "T": 8, "U": 8, "V": 8,
    "W": 9, "X": 9, "Y": 9, "Z": 9,
    "OPERATOR": 0, 
}

# 시간 맞추기
TIME_GAP = 1
for key in dial_dict.keys():
    dial_dict[key] += TIME_GAP
    
words = input()
time_sum = 0
for word in words:
    time_sum += dial_dict[word]
print(time_sum)