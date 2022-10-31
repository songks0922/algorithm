def is_palindrome(word):
    word_len = len(word) // 2
    for i in range(0, word_len):
        if word[i] != word[(i+1) * -1]:
            return False
    else:
        return True

# 테스트
print(is_palindrome("racecar"))
print(is_palindrome("stars"))
print(is_palindrome("토마토"))
print(is_palindrome("kayak"))
print(is_palindrome("hello"))
