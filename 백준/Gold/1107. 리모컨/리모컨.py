'''
# n의 각 자리 수에 해당하는 숫자가 True이면 쓰고
# False라면? 그 밑의 숫자
'''
import sys
input = sys.stdin.readline

# # 이동하려고 하는 채널 n
n = int(input())

# 고장난 버튼의 개수 m개
m = int(input())
broken = list(map(int, input().split()))

# # 결과: n으로 이동하기 위해 버튼 최소 몇 번 눌러야함?
min_cnt = abs(100 - n)  # 최대값으로 설정

for nums in range(1000001):
    nums = str(nums)

    for i in range(len(nums)):
        if int(nums[i]) in broken:
            break
        elif i == len(nums) - 1:  # 마지막 숫자가 고장난 버튼이 아닐 경우
            min_cnt = min(min_cnt, len(nums) + abs(n - int(nums)))

print(min_cnt)
