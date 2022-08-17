'''
<스택>
스택 수열

불가능한 경우는 어떤 경우인가?
=> 주어진 수열이
'''

# 수열 입력받기
n = int(input())
targets = []
for _ in range(n):
    targets.append(int(input()))

stack = []
answer = []


# 1~ n+1까지 입력
current = 1
for target in targets:
    while current <= target:
        stack.append(current)
        answer.append('+')
        current += 1
    if stack[-1] == target:
        stack.pop()
        answer.append('-')

# stack에 아직 숫자가 남아있다면
if stack:
    print('NO')
else:
    for x in answer:
        print(x)
