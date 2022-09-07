'''
최소힙
'''

import sys, heapq

input = sys.stdin.readline
heap = []

for i in range(int(input())):
    n = int(input())
    if n == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, n)


