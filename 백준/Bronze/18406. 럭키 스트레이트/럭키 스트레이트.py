n = input()

size = len(n)
# 합을 구하는 함수
def cal_sum(s, e):
    sum = 0
    for i in range(s, e):
        sum += int(n[i])
    return sum
# 구한 두 합을 비교하여 결과 출력
sum1 = cal_sum(0, size//2)
sum2 = cal_sum(size//2, size)

if sum1 == sum2:
    print("LUCKY")
else:
    print("READY")