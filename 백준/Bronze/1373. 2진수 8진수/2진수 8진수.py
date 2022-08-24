n = input()
res = []

for i in range(len(n)-1, -1, -3):
    sum = 0
    for j in range(0, 3):
        if i-j < 0:
            continue
        else:
            sum += (int(n[i-j]) * (2 **j))
    res.append(str(sum))

print(''.join(reversed(res)))