'''
에디터
'''

a = input()
n = int(input())
stack = []
tmp = [] # pop한 원소 저장할 테이블

for s in a:
    stack.append(s)

for _ in range(n):
    command = input().split()
    com = command[0] #명령어
    if com == 'P':
        stack.append(command[1])

    elif com == 'L':
        if stack:
            tmp.append(stack.pop())
        else:
            continue
    elif com == 'B':
        if stack:
            stack.pop()
        else:
            continue
    elif com == "D":
        if tmp:
            stack.append(tmp.pop())
        else:
            continue

#tmp에 남은 원소 붙여주기
# if tmp:
#     stack.extend(list(reversed(tmp)))

# for x in stack:
#     print(x, end='')

print("".join(stack + list(reversed(tmp))))
