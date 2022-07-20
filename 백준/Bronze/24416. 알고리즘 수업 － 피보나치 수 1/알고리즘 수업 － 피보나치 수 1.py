n = int(input())
dy = [0] * (n+1)

#재귀
def fib(n):
    global code1
    if n == 1 or n == 2:
        code1 += 1
        return 1
    else:
        return fib(n-1) + fib(n-2)

code1 = 0
code2 = 0

#동적
def fibonacci(n):
    global code2
    dy[1] = 1
    dy[2] = 1

    for i in range(3, n+1):
        code2 +=1
        dy[i] = dy[i-1]+dy[i-2]
    return dy[n]
fib(n)
fibonacci(n)

print(code1, code2, end=' ')