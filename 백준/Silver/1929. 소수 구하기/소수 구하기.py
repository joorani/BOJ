def eratos(n):
    ch = [False for _ in range(n+1)]
    res = [] #소수를 담은 테이블
    for i in range(2, n+1):
        if ch[i]:
            continue
        res.append(i)
        for j in range(i*i, n+1, i):
            ch[j] = True
    return res


m, n = map(int, input().split())
result = eratos(n)
for x in result:
    if m <= x <= n:
        print(x)