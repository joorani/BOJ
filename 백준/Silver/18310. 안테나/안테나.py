n = int(input())
antenas = list(map(int, input().split()))

antenas.sort()

print(antenas[(n-1)//2])