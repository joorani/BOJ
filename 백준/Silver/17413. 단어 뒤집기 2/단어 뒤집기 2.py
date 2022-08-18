'''
단어 뒤집기2
'''
from collections import deque


s = input()
answer = []
stack = []
q = deque(s)
while q:
    if q[0] == '<':
        while stack:
            answer.append(stack.pop())
        while True:
            answer.append(q.popleft())
            if answer[-1] == '>':
                break
    elif q[0] == ' ':
        while stack:
            answer.append(stack.pop())
        answer.append(q.popleft())
    else:
        stack.append(q.popleft())

while stack:
    answer.append(stack.pop())

print(''.join(answer))
