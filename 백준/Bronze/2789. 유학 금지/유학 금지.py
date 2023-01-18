restrict = "CAMBRIDGE"
word = input()

for i_char in word:
    if i_char not in restrict:
        print(i_char, end="")