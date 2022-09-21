
'''
BFS
2
10 8 17
10 10 1
'''
from collections import deque
#입력받기
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def BFS(a, b):
    dq = deque()
    dq.append((a, b))
    while dq:
        x, y = dq.popleft()
        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            if 0<=mx<n and 0<=my<m and board[mx][my]== 1:
                board[mx][my] = 0
                dq.append((mx, my))


for _ in range(int(input())):
    m, n, k = map(int, input().split())
    board = [[0] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, input().split())
        board[y][x] = 1

    cnt=0
    # dq = deque()
    for i in range(n):
        for j in range(m):
            if board[i][j] == 1:
                BFS(i, j)
                cnt += 1


    print(cnt)
