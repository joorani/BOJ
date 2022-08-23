def isPrime2(n):
    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True

n = int(input())
a = list(map(int, input().split()))
cnt = 0
for x in a:
    if isPrime2(x) and x != 1:
        cnt+= 1
        
print(cnt)
