'''
BFS
'''
from collections import deque

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for g in graph:
    g.sort()


visited = [0] * (n+1)
path = deque()
path.append(r)
cnt = 1
visited[r] = cnt
while path:
    now = path.popleft()
    for node in graph[now]:
        if visited[node] == 0:
            cnt += 1
            visited[node] = cnt
            path.append(node)

# 출력
for i in range(1, n+1):
    print(visited[i])

