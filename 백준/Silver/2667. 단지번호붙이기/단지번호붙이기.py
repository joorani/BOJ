
import sys

#입력받기
n = int(input())
board = [[int(i) for i in sys.stdin.readline().rstrip()] for _ in range(n)]

home = 0 #단지 내 집의 수
homes = []

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def DFS(x, y):
    global home
    home+= 1
    board[x][y] = 0 #방문했음을 체크
    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if mx >= 0 and my >= 0 and mx < n and my < n and board[mx][my] == 1:
            DFS(mx, my)

for i in range(n):
    for j in range(n):
        if board[i][j]== 1:
            home = 0
            DFS(i, j)
            homes.append(home)

#출력
print(len(homes))
homes.sort() #오름차순 정렬
for x in homes:
    print(x)
