def DFS(L, sum):
    global res
    if L == n:
        if sum > res:
            res = sum
    else:
        if L+time[L] <=n:
            DFS(L+time[L], sum+p[L])
        DFS(L+1, sum)

if __name__ == '__main__':
    n = int(input())
    time = []
    p = []
    for _ in range(n):
        t, money = map(int, input().split())
        time.append(t)
        p.append(money)
    res = 0
    for i in range(n):
        DFS(i, 0)
    print(res)
