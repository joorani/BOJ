'''
백준 14502

벽 설치는 좌표값이 0이면 어디든 가능
바이러스가 퍼지는 것을 어떻게 구현?
좌표가 0 인 갯수 카운트 -> 안전영역 count
'''

# 지도 세로크기, 가로크기 입력받기
n, m = map(int, input().split())

#입력받은 연구소 좌표 데이터
graph = [list(map(int, input().split())) for _ in range(n)]
# 벽이 세워진 이후 좌표
after = [[0] * m for _ in range(n)]

# 상하좌우 좌표이동 리스트
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

#안전영역 개수 카운트
def get_safe():
    cnt = 0
    for i in range(n):
        for j in range(m):
            if after[i][j] == 0:
                cnt+= 1

    return cnt


def virus(x, y):
    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]
        if xx >=0 and yy >=0 and xx < n and yy <m:
            if after[xx][yy] == 0:
                after[xx][yy] = 2
                virus(xx, yy)


def DFS(count):
    global result
    #벽을 3개 다 세웠으면 virus 퍼져나가는 것을 처리
    if count == 3:
        # 벽을 세웠다고 가정한 그래프 완성
        for i in range(n):
            for j in range(m):
                after[i][j] = graph[i][j]

        #virus 전파
        for i in range(n):
            for j in range(m):
                if after[i][j] == 2:
                    virus(i, j)

        #안전영역 개수 카운트하고 종료
        result = max(result, get_safe())
        return

    # 좌표값이 0이면 벽을 세울 수 있음
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                count += 1
                DFS(count)
                graph[i][j] = 0
                count -= 1


result = 0
DFS(0)
print(result)
