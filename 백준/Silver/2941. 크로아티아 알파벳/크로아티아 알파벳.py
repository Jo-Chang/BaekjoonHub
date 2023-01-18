word_input = input()

chro_alphabet = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
word_len = len(word_input)
for alphabet in chro_alphabet:
    word_len -= word_input.count(alphabet)

print(word_len)