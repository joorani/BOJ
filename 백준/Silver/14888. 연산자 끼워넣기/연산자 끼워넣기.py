'''
연산자 끼워넣기

주어진 연산자 순열로

'''


n = int(input())
data = list(map(int, input().split()))
operator = list(map(int, input().split())) #연산자 순서대로

# 최대값, 최솟값 초기화
max_value = -1e9
min_value = 1e9

def DFS(L, now):
    global min_value, max_value
    if L == n:
        min_value = min(min_value, now)
        max_value = max(max_value, now)
    else:
        # 덧셈, 뺼셈, 곱셈, 나눈셈
        for i in range(4):
            if operator[i] != 0:
                operator[i]-= 1 # 사용했으면 1개씩 뺴준다.
                tmp=calculator(i, now, data[L])
                DFS(L+1, tmp)
                operator[i] += 1


def calculator(index, a, b):
    if index == 0:
        return a+b
    elif index == 1:
        return a - b
    elif index == 2:
        return a * b
    else:
        if a< 0 and b >0:
            return -(abs(a) // abs(b))
        return a//b

DFS(1, data[0])
print(max_value)
print(min_value)

