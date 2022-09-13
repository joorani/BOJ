'''
괄호의 값
'''

data = input()
stack = []
tmp = 1 # result에 더해주기 전 임시 변수
result = 0  # 결과 변수

for i in range(len(data)):
    #열린 괄호
    if data[i] == '(':
        stack.append(data[i])
        tmp *= 2
    elif data[i] == '[':
        stack.append(data[i])
        tmp *= 3
    elif data[i] == ')':
        # stack이 비었거나 열린 괄호가 아니면 중지
        if not stack or stack[-1] == '[':
            result = 0
            break
        if data[i-1] == '(':
            result += tmp
        tmp //= 2
        stack.pop()
    else:
        if not stack or stack[-1] == '(':
            result = 0
            break
        if data[i-1] == '[':
            result += tmp
        tmp //= 3
        stack.pop()
#출력
if stack:
    print(0)
else:
    print(result)
