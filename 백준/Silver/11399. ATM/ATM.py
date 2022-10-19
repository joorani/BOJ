n = int(input())
a = list(map(int, input().split()))

time = []

for i in range(n):
    time.append((i+1, a[i]))

time.sort(key= lambda x:(x[1], x[0]))

min_time = 0
tmp = 0
for idx, t in time:
    tmp = tmp+t
    min_time += tmp

print(min_time)