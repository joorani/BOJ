'''
<큐>
큐 구현하기
'''

from collections import deque
import sys
input = sys.stdin.readline
queue = deque()

def push(x):
    queue.append(x)

def pop():
    if queue:
        return queue.popleft()
    else:
        return -1

def front():
    if queue:
        return queue[0]
    else:
        return -1

def back():
    if queue:
        return queue[-1]
    else:
        return -1

def size():
    if queue:
        return len(queue)
    else:
        return 0

def empty():
    if queue:
        return 0
    else:
        return 1

if __name__ == '__main__':

    n = int(input())
    for _ in range(n):
        com = input().split()
        if com[0] == 'push':
            push(com[1])
        else:
            answer = 0
            if com[0]=='front':
                answer = front()
            elif com[0] == 'back':
                answer = back()
            elif com[0] == 'size':
                answer = size()
            elif com[0] == 'empty':
                answer = empty()
            elif com[0] == 'pop':
                answer = pop()

            print(answer)
