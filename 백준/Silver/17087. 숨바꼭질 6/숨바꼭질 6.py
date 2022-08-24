def gcd(a, b):
    return b if a % b == 0 else gcd(b, a % b)
# 동생 n명, 수빈 위치 s
n, s = map(int, input().split())

# 동생들의 위치
dis = list(map(int, input().split()))

d = abs(dis[0]-s)
for i in range(1, n):
    d = gcd(dis[i]-s, d)
print(d)