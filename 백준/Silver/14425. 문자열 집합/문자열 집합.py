# 14425. 문자열 집합

import sys

# sys.stdin = open("14425.txt")


set_size, word_num = map(int, sys.stdin.readline().split())

word_set = set([])
for T in range(set_size):
    word_set.add(sys.stdin.readline())

cnt = 0
for T in range(word_num):
    if sys.stdin.readline() in word_set:
        cnt += 1
        
print (cnt)