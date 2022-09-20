from collections import deque
import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)
n, m, r = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a) #무방향 그래프이기 때문에 양쪽에 넣어줘야함.

visited = [0] *(n+1)
visited[r] = 1
dfs_path = [] #경로를 담을 테이블
dfs_path.append(r)
def DFS(L, s):
    g[s].sort()
    for i in g[s]:
        if visited[i] == 0:
            visited[i] = 1
            dfs_path.append(i)
            DFS(L + 1, i)


dq = deque()
dq.append(r)
bfs_path = []
def BFS(r):
    visited = [0] * (n+1)
    visited[r] = 1
    while dq:
        now = dq.popleft()
        bfs_path.append(now)
        for i in g[now]:
            if visited[i] == 0:
                visited[i] = 1
                dq.append(i)

DFS(1, r)
print(*dfs_path)
BFS(r)
print(*bfs_path)

