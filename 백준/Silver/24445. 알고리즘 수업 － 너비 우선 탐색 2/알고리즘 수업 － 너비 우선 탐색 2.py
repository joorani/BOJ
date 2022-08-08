from collections import deque
# 정점의 수, 간선의 수, 시작 정점 입력받기
n, m, r = map(int, input().split())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 그래프 내림차순으로 정렬
for g in graph:
    g.sort(reverse=True)

visited = [0] * (n+1)
#시작 정점 입력
path = deque()
path.append(r)
cnt = 1
visited[r] = cnt

while path:
    now = path.popleft()
    for node in graph[now]:
        if visited[node] == 0:
            path.append(node)
            cnt+=1
            visited[node] = cnt

for i in range(1, n+1):
    print(visited[i])
