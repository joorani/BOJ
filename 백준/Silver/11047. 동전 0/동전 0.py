
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coins = []
for _ in range(n):
    coins.append(int(input()))

coins.sort(reverse=True)
cnt = 0
for coin in coins:
    if coin <=k:
        cnt += k // coin
        k = k%coin
        if k == 0:
            print(cnt)
            break
