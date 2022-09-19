'''
BFS
'''
from collections import deque
import sys
input = sys.stdin.readline

n, m, r = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a) #무방향 그래프이기 때문에 양쪽에 넣어줘야함.

visited = [0] * (n+1) # 방문 순서 기록, cnt를 저장할 테이블임
cnt = 1 #방문 순서를 기록할 변수
dq = deque()

def bfs():
    global cnt
    while dq:
        now = dq.popleft()
        g[now].sort()
        for i in g[now]:
            if visited[i] == 0:
                cnt+= 1
                visited[i] = cnt
                dq.append(i)

visited[r] = cnt
dq.append(r) #시작 노드 추가
bfs()
for x in range(1, n+1):
    print(visited[x])
