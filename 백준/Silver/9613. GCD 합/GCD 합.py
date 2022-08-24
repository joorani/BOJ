import sys
input = sys.stdin.readline

def gcd(a, b):
    return b if a % b == 0 else gcd(b, a%b)

n = int(input())
for _ in range(n):
    nums = list(map(int, input().split()))
    gcd_sum = 0
    size = nums[0]
    for i in range(1, size):
        for j in range(i+1, size+1):
            gcd_sum += gcd(nums[i], nums[j])

    print(gcd_sum)