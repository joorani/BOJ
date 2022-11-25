n = int(input())
dy = [0]*(n+1)

for i in range(2, n+1):
    #1을 빼는 경우
    dy[i] = dy[i-1]+1
    #2로 나누어 떨어지는 경우
    if i % 2 == 0:
        dy[i] = min(dy[i], dy[i//2]+1)
    #3으로 나누어 떨어지는 경우
    if i % 3 == 0:
        dy[i] = min(dy[i], dy[i//3] + 1)

print(dy[n])