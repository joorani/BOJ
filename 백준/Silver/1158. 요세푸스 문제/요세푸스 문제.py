from collections import deque
#
n, k = map(int, input().split())
q = deque([i for i in range(1, n+1)]) # 1~n까지 초기화
answer = []
# while q:
#     if len(q)== 1:
#         answer.append(q[0])
#         break
#     for _ in range(k-1):
#         q.append(q.popleft())
#     answer.append(q.popleft())
#
# # # 결과 출력
# print('<' + ', '.join(map(str, answer)) + '>')

# 2번째 방법 rotate(이용)
while q:
    q.rotate(-(k-1))
    answer.append(q.popleft())

print('<' + ', '.join(map(str, answer)) + '>')
