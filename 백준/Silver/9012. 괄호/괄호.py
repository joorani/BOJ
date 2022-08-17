'''
<스택>
괄호

'''

n = int(input())

for _ in range(n):
    ps = input()
    stack = []
    result = True
    for i in range(len(ps)):
        if ps[i] == '(':
            stack.append('(')
        else:
            if len(stack) != 0:
                stack.pop()
            else:
                result = False
                break

    if len(stack) == 0 and result:
        print('YES')
    else:
        print("NO")
