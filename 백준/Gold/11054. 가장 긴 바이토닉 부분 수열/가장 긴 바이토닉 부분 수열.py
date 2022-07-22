# 증가하는 수열 개수
def increase(n):
    dy = [0] * n
    for i in range(n):
        dy[i] = 1
        for j in range(i - 1, -1, -1):
            if arr[i] > arr[j]:
                dy[i] = max(dy[i], dy[j] + 1)

    return dy


# 감수하는 수열 개수
def decrease(n):
    res = 0
    dy = [0] * n
    for i in range(n - 1, -1, -1):
        dy[i] = 1
        for j in range(i + 1, n):
            if arr[i] > arr[j]:
                dy[i] = max(dy[i], dy[j] + 1)

    return dy


# 출력
n = int(input())
arr = list(map(int, input().split()))
result = [0] * n
increase = increase(n)
decrease = decrease(n)
for i in range(n):
    result[i] = (increase[i] + decrease[i]) -1

print(max(result))