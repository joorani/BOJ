import heapq

n = int(input())
cards = []
for _ in range(n):
    heapq.heappush(cards, int(input()))

res = 0

while len(cards) != 1:
    one = heapq.heappop(cards)
    two = heapq.heappop(cards)
    value = one+two
    res += value
    heapq.heappush(cards, value)

print(res)