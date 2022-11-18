'''
트리의 부모 찾기

'''
from collections import deque
import sys
input = sys.stdin.readline


n = int(input())
tree = [[] for _ in range(n+1)]
visited = [False] * (n+1)
parents = [0] * (n+1)

# tree 입력받기
for _ in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

'''
def DFS(start, tree, parents):
    for i in tree[start]:
        if parents[i] == 0:
            parents[i] = start
            DFS(i, tree, parents)
DFS(1, tree, parents)
'''

def bfs(tree,root, visited):
    que = deque([root])
    visited[root] = True

    while que:
        now = que.popleft()
        for i in tree[now]:
            if not visited[i]:
                que.append(i)
                parents[i] = now
                visited[i] = True

bfs(tree, 1, visited)
#결과 출력
for i in range(2, n+1):
    print(parents[i])
