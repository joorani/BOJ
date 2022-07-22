n = int(input())
arr = list(map(int, input().split()))

#1.n**2
dp = [0]*(n+1)
res = 0
for i in range(n):
    dp[i] = 1
    for j in range(i-1, -1, -1):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)

    if dp[i] > res:
        res = dp[i]
print(res)