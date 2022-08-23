# 최대공약수
def gcd(a, b):
    return b if a % b == 0 else gcd(b, a%b)

# 최소공배수
def lcm(a, b):
    g = gcd(a, b)
    return ((a*b) // g)


a,b = map(int, input().split())

print(gcd(a, b))
print(lcm(a, b))
