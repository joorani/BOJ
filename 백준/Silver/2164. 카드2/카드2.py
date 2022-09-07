from collections import deque

dq = deque(list(i for i in range(1, int(input())+1)))

while len(dq) >1:
    dq.popleft()
    dq.rotate(-1) #왼쪽으로 회전
print(dq[0])