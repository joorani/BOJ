import sys
input = sys.stdin.readline

n = int(input())
distance = list(map(int, input().split()))
oil_price = list(map(int, input().split()))

cost = oil_price[0]
tmp = cost * distance[0]

for i in range(1, n-1):
    if oil_price[i] < cost:
        cost = oil_price[i]
        tmp += cost * distance[i]
    else:
        tmp += cost * distance[i]
print(tmp)
