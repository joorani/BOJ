
n = int(input())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

board.sort(key=lambda x: (x[0], x[1]))

for b in board:
    print(str(b[0]) + " "+ str(b[1]))

