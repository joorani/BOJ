def DFS(L):
    if L == m:
        for x in res:
            print(x, end= ' ')
        print()
    else:
        for i in range(n):
            if L > 0:
                if data[i] >= res[L-1]:
                    res[L] = data[i]
                    DFS(L+1)
            else:
                res[L] = data[i]
                DFS(L+1)

if __name__ == '__main__':

    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    data.sort()
    res = [0] * m
    DFS(0)
