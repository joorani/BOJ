# '''
# 스택 구현하기
# '''
#
#
# 정수를 스택에 넣는 연산
import sys
input = sys.stdin.readline

def push(num):
    stack.append(num)


def pop():
    if len(stack) == 0:
        return -1
    else:
        return stack.pop()


def size():
    return len(stack)


def empty():
    if len(stack):
        return 0
    else:
        return 1

def top():
    if len(stack) == 0:
        return -1
    else:
        return stack[-1]

if __name__ == '__main__':

    n = int(input())
    stack = []
    for _ in range(n):
        command = input().split()
        res = 0
        if len(command) >1:
            #push인 경우
            com, x = command[0], command[1]
            push(int(x))
        else:
            c = command[0]
            if c == 'top':
                res = top()
            elif c == 'size':
                res = size()
            elif c == 'empty':
                res =empty()
            elif c == 'pop':
                res = pop()


            print(res)
