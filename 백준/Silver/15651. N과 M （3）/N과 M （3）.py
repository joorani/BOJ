'''
백트래킹 3
'''

def DFS(L):
    if L == m:
        for num in res:
            print(num, end= ' ')
        print()
    else:
        for i in range(1, n+1):
            res[L] = i
            DFS(L+1)


if __name__ == '__main__':
    n, m = map(int, input().split())

    res = [0] * m # 수열을 담을 테이블
    DFS(0)
