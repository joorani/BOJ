''''
연산자 끼워넣기
'''

n = int(input())
numbers = list(map(int, input().split()))
calculator = list(map(int, input().split()))

max_res = -1e9
min_res = 1e9

def dfs(L, now):
    global max_res, min_res
    if L == n:
        max_res = max(max_res, now)
        min_res = min(min_res, now)
    else:
        for i in range(4):
            if calculator[i] != 0:
                calculator[i] -=1
                dfs(L+1, cal(i, now, numbers[L]))
                calculator[i] += 1

def cal(index, a, b):
    if index == 0:
        return a+b
    elif index == 1:
        return a -b
    elif index == 2:
        return a * b
    else:
        if a< 0 and b >0:
            return -(abs(a) // abs(b))
        return a//b

dfs(1, numbers[0])
print(max_res)
print(min_res)
