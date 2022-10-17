n = int(input())
data = []
for x in range(n):
    data.append(int(input()))

'''
삽입 정렬
'''

for i in range(1, n):
    for j in range(i, 0, -1):
        if data[j-1] > data[j]:
            # target 값보다 크면 swap
            data[j], data[j-1] = data[j-1], data[j]
        # target 값보다 작으면
        else:
            break

for x in data:
    print(x)
