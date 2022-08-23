def factorial(n):
    if n == 0:
        return 1
    if n == 1 or n == 2:
        return n
    return n * factorial(n-1)

n = int(input())
s = str(factorial(n))
cnt = 0
for i in range(len(s)-1, -1, -1):
    if int(s[i]) == 0:
        cnt+= 1
    else:
        print(cnt)
        break