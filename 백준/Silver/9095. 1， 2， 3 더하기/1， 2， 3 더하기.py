def DFS(goal, sum):
    global cnt
    if sum > goal:
        return
    if sum == goal:
        cnt += 1
        return
    else:
        for i in range(1, 4):
            DFS(goal, sum+i)

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input()) #계속 바뀜
        cnt = 0
        DFS(n, 0)
        print(cnt)