def solution(n, computers):
    cnt = 0
    visited = [False] * (n+1)
    for com in range(n):
        if visited[com] == False:
            DFS(n, computers, com, visited)
            cnt+= 1
    return cnt
            

def DFS(n, computers, com, visited):
        visited[com] = True
        for connect in range(n):
            if connect != com and computers[com][connect] == 1:
                if visited[connect] == False:
                    DFS(n, computers, connect, visited)
                