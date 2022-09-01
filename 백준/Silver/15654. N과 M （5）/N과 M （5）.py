def dfs(L):
    if L == m:
        for x in res:
            print(x, end=' ')
        print()
    else:
        for i in range(n):
            if ch[i] == 0:
                ch[i] = 1
                res[L] = data[i]
                dfs(L+1)
                ch[i] = 0

n, m = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
ch = [0] * n
res = [0] * m
dfs(0)