max_num = 1000001


def eratos(n):
    ch = [True for _ in range(n)]
    for i in range(2, n):
        if ch[i]:
            for j in range(i*i, n, i):
                ch[j] = False
    return ch
arr = eratos(max_num)
while True:
    n = int(input())
    if n == 0:
        break
    flag = 0
    # n을 포함하지 않는 n까지 소수 리스트
    for a in range(3, n):
        if arr[a] and arr[n-a]:
            print(f'{n} = {a} + {n-a}')
            flag = 1
            break
    if flag == 0:
        print("Goldbach's conjecture is wrong.")
