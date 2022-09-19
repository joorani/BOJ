'''
bfs
'''

from collections import deque

n = int(input())
m = int(input())
g = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

dq = deque()
dq.append(1)
cnt = 0 #연결된 노드 수
visited = [0] * (n+1)
visited[1] = 1 #시작노드
while dq:
    now = dq.popleft()
    for i in g[now]:
        if visited[i] == 0:
            visited[i] = 1
            dq.append(i)
            cnt+=1
print(cnt)
