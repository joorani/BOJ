n = int(input())
score = []

# 입력받기
for _ in range(n):
    name, a, b, c = input().split()
    score.append((name, int(a), int(b), int(c)))


res = sorted(score, key= lambda x: (-x[1], x[2], -x[3], x[0]))

for x in res:
    print(x[0])