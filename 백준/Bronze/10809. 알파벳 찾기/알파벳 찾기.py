alphabet = "abcdefghijklmnopqrstuvwxyz"
word = input()

list_index = []
for i_char in alphabet:
    list_index.append(word.find(i_char))
print(*list_index)
    