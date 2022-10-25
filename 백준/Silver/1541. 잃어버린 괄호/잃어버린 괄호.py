s = input().split("-")

sum = 0
for i in s[0].split('+'):
    sum += int(i)

for a in s[1:]:
    sum2= 0
    for j in a.split('+'):
        sum2+= int(j)
    sum -= sum2

print(sum)