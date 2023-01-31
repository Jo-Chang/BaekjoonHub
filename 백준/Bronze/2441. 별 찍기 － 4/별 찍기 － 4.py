import sys


def print_star(num):
    for i in range(num):
        print(" " * i + "*" * (num-i))
        
    
print_star(int(sys.stdin.readline()))