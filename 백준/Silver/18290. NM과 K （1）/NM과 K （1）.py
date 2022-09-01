'''
for문을 돌면서 방문했다면 pass
'''
import sys
input = sys.stdin.readline

def DFS(px, py, idx, sum):
    global res
    if idx == k:
        if sum > res:
            res = sum
        return
    else:
        for x in range(px, n):
            for y in range(py if x == px else 0, m):
                #현재 위치를 방문 했다면
                if visitied[x][y]:
                    continue
                flag = True
                for i in range(4):
                    xx = x + dx[i]
                    yy = y + dy[i]
                    if 0 <= xx < n and 0 <= yy < m:
                        if visitied[xx][yy]:
                            #인접한 경우
                            flag = False

                if flag:
                    visitied[x][y] = True
                    DFS(x, y, idx+1, sum+board[x][y])
                    visitied[x][y] = False


if __name__ == '__main__':
    n,m,k = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    res = -1e9
    visitied = [[False] *m for _ in range(n)]

    DFS(0, 0, 0, 0)

    print(res)
