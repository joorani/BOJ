m = int(input())
n = int(input())

res = []
for num in range(m, n+1):
    if num == 1:
        continue
    for i in range(2, int(num**(1/2))+1):
        if num % i == 0:
            break
    else:
        res.append(num)
        
#결과 출력
if len(res) == 0:
    print(-1)
else:
    print(sum(res))
    print(min(res))