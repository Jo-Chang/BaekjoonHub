import sys


# input
message = sys.stdin.readline().strip()
    

# solution
def get_mood(word):
    happy_num = word.count(":-)")
    sad_num = word.count(":-(")
    
    if happy_num == sad_num == 0:
        return "none"
    elif happy_num == sad_num:
        return "unsure"
    elif happy_num > sad_num:
        return "happy"
    else:
        return "sad"

# print
print(get_mood(message))