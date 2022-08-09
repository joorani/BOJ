'''
boj
18405


'''
from collections import deque
n, k = map(int, input().split())

#입력받는 시험관
graph = [list(map(int, input().split())) for _ in range(n)]

# (바이러스 종류, 시간, x좌표, y좌표) 넣을 큐
virus_data = []
# s초 후, after(x-1, y-1)좌표 출력
target_s, target_x, target_y = map(int, input().split())

#상하좌우 방향 리스트
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

#0초에서 바이러스 큐에 넣어줌
for i in range(n):
    for j in range(n):
        if graph[i][j] != 0:
            virus_data.append((graph[i][j], 0, i, j))


# 번호가 낮은 종류의 바이러스부터 먼저 증식하므로 정렬
virus_data.sort()
que = deque(virus_data)

while que:
    virus, sec, x, y = que.popleft()

    # target초가 되면 종료한다.
    if sec == target_s:
        break

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # nx, ny 허용 범위
        if nx >=0 and ny >=0 and ny < n and nx < n:
            # 아직 방문하지 않았다면
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                que.append((graph[nx][ny], sec+1, nx, ny))


print(graph[target_x-1][target_y-1])
