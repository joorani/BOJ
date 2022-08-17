'''
백트래킹 2
'''


def DFS(L, before):
    if L == m:
        for num in res:
            print(num, end= ' ')
        print()
    else:
        for i in range(1, n+1):
            if ch[i] == 0 and before < i:
                res[L] = i
                ch[i] = 1
                DFS(L+1, i)
                ch[i] = 0


if __name__ == '__main__':
    #n,m 입력받기
    n, m = map(int, input().split())

    res = [0] * m
    ch = [0] * (n+1) #중복체크 할 배열
    DFS(0, 0)
