'''
그리디
회의실 배정

'''

n = int(input())
classes= []

for _ in range(n):
    s, e = map(int, input().split())
    classes.append((s, e))

# 끝나는 시간 기준으로 오름차순 정렬
classes.sort(key=lambda x:(x[1], x[0]))
cnt = 0
end_time = 0
for s, e in classes:

    if s>= end_time:
        end_time = e
        cnt+= 1

print(cnt)
