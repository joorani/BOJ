import sys

input = sys.stdin.readline
n = int(input())
a = list(map(int, input().split()))

stack = [0]
result = [-1] * n

for i in range(1, n):
    while stack and a[stack[-1]] <a[i]:
        result[stack.pop()] = a[i]
    stack.append(i)

for x in result:
    print(x, end= ' ')