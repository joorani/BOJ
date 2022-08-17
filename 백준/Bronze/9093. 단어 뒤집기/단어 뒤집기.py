n = int(input())
for _ in range(n):
    sentences = input().split()
    for word in sentences:
        tmp = ''
        for i in range(len(word)):
            tmp += word[len(word)-1-i]
        print(tmp, end= ' ')
    print()