'''
백트래킹 4
'''

def DFS(L, before):
    if L == m:
        for num in res:
            print(num, end= ' ')
        print()
    else:
        for i in range(1, n+1):
            if i >= before:
                res[L] = i
                DFS(L+1, i)

if __name__ == '__main__':
    n, m = map(int, input().split())

    res = [0] * m
    DFS(0, 1)
