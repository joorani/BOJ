'''
시뮬레이션

투 포인터
양쪽 포인터가 전체 중 가장 높은 블록을 향해 나아가야 한다.

'''


h, w = map(int,input().split())
block = list(map(int, input().split())) # 3,0,1,4
cnt = 0

left_idx=0
right_idx = w-1
left_max = block[left_idx]
right_max = block[right_idx]
result =0

# block이 빈 리스트라면 0을 return
# if not block:
#     print(0)
while left_idx < right_idx:
    left_max = max(left_max, block[left_idx])
    right_max = max(right_max, block[right_idx])

    if left_max <= right_max:
        result += left_max-block[left_idx]
        left_idx += 1
    else:
        result += right_max-block[right_idx]
        right_idx -= 1

print(result)

