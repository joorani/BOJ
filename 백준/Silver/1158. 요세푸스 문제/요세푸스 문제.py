'''
요세푸스 문제
'''
from collections import deque

n, k = map(int, input().split())
q = deque()
#1~ n+1까지 초기화
for i in range(1, n+1):
    q.append(i)

answer = []
while q:
    if len(q)== 1:
        answer.append(q[0])
        break
    for _ in range(k-1):
        q.append(q.popleft())
    answer.append(q.popleft())

# # 결과 출력
print('<' + ', '.join(map(str, answer)) + '>')
