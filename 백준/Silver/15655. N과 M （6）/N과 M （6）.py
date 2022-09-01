
def DFS(L, s):
    if L == m:
        for x in res:
            print(x, end= ' ')
        print()
    else:
        for i in range(s, n):
            res[L] = data[i]
            DFS(L+1, i+1)

if __name__ == '__main__':

    n, m = map(int, input().split())
    data = list(map(int, input().split()))

    data.sort()
    res = [0] * m
    DFS(0, 0)
