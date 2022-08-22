import sys
input = sys.stdin.readline

n= int(input())
a = list(map(int, input().split()))

# f = [0] * (max(a)+1)
f = [0] * 1000001
for x in a:
    f[x] += 1
result = [-1] * n

stack = [0]

for i in range(1, n):
    while stack and f[a[stack[-1]]] < f[a[i]]:
        result[stack.pop()] = a[i]
    stack.append(i)

for x in result:
    print(x, end = ' ')



