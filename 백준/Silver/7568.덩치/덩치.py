#브루트포스 알고리즘
n = int(input())

people=[]
for i in range(n):
    x, y = map(int, input().split())
    people.append((x, y))

for i in range(n):
    ranking = 1
    for j in range(n):
        #덩치가 작으면 등수 +1
        if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            ranking += 1
    print(ranking, end=' ')
