#최대공약수
def gcd(a, b):
    return b if a % b == 0 else gcd(b, a%b)

n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    print((a*b)//gcd(a, b))
 