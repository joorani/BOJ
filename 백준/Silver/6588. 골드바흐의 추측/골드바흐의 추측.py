def isPrime(n):
    i = 2
    while i * i <= n:
        if n % i == 0:
            return False
        i += 1
    return True

while True:
    n = int(input())
    if n == 0:
        break
    else:
        a = 2
        while a < n:
            if isPrime(a) and isPrime(n - a):
                print(f'{n} = {a} + {n-a}')
                break
            a += 1
        else:
            print("Goldbach's conjecture is wrong.")

