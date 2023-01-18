word_input = input()

word_len = len(word_input)
word_len -= word_input.count("c=")
word_len -= word_input.count("c-")
word_len -= word_input.count("dz=")
word_len -= word_input.count("d-")
word_len -= word_input.count("lj")
word_len -= word_input.count("nj")
word_len -= word_input.count("s=")
word_len -= word_input.count("z=")

print(word_len)