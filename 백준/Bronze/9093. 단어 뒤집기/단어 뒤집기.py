'''
단어 뒤집기
'''

n = int(input())
for _ in range(n):
    sentences = input().split()
    for word in sentences:
        print(word[::-1], end=' ')
    print()

