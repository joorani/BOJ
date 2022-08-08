'''
트리의 지름

'''

from collections import deque
import sys
input = sys.stdin.readline

# 정점의 개수
v = int(input())

# tree 입력받기
tree = [[] for _ in range(v+1)]
for _ in range(v):
    info = list(map(int, input().split()))
    # 간선
    node = info[0]
    for i in range(1, len(info) - 1, 2):
        tree[node].append(info[i:i+2])

def bfs(start):
    visited = [-1] * (v+1)
    que = deque([start])
    visited[start] = 0

    # 거리가 가장 먼 트리의 지름과 정점을 저장하는 배열
    max_node = [0,0]
    while que:
        now = que.popleft()
        for end_node, dis in tree[now]:
            if visited[end_node] == -1:
                visited[end_node] = visited[now] + dis
                que.append(end_node)
                if max_node[0] < visited[end_node]:
                    max_node = visited[end_node], end_node
    return max_node


sum_distance, last_node = bfs(1)
dist, node = bfs(last_node)
print(dist)
