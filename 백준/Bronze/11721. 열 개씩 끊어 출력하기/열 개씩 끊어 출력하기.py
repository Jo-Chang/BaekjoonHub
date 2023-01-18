sentence = input()

for i_num in range(1, len(sentence) // 10 + 1):
    print(sentence[10*(i_num - 1):10*i_num])
print(sentence[len(sentence) // 10 * 10:])