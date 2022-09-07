'''
최소힙
'''

import sys, heapq

input = sys.stdin.readline
heap = []

for i in range(int(input())):
    n = int(input()) * -1
    if n == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap)*-1)
    else:
        heapq.heappush(heap, n)


