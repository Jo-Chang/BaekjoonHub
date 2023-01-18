def is_palindrome(word):
    for i in range(len(word) // 2 + 1):
        if (word[i] == word[-1 - i]):
            pass
        else:
            return 0
    return 1
    
print(is_palindrome(input()))