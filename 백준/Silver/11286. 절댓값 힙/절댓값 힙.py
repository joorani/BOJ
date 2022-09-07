import sys, heapq

input = sys.stdin.readline
heap = []

for _ in range(int(input())):
    n = int(input())
    # 음수인 경우
    if n == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    elif n < 0:
        heapq.heappush(heap, (n * -1, n))
    else:
        heapq.heappush(heap, (n, n))

