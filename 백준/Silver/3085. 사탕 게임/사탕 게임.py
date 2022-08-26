'''
사탕게임

자리를 바꾸는 건 1번
자리를 바꾸고 -> 탐색하여 최대값(이전값보다 탐색한 값이 더 크면 갱신) -> 자리원위치
3
ABC
ABC
ABC
* 자리를 바꾸는 방법
1. 옆이랑

2. 아래랑
'''


# 옆에 있는 사탕이랑 바꾸는 경우
import copy


def rightChange(x, y, board):
    board[x][y], board[x][y + 1] = board[x][y + 1], board[x][y]  # switch
    return board


# 아래 있는 사탕이랑 바꾸는 경우
def downChange(x, y, board):
    board[x][y], board[x + 1][y] = board[x + 1][y], board[x][y]
    return board

# 전체 테이블의 행을 탐색하는 함수
def hSearch(board):
    tmp = 1
    for i in range(n):
        start = board[i][0]
        cnt = 1
        for j in range(1, n):
            if board[i][j] == start:
                cnt += 1
                tmp = max(tmp, cnt)
            else:
                start = board[i][j]
                cnt = 1
    return tmp

# 전체 테이블의 열을 탐색하는 함수
def ySearch(board):
    tmp = 1
    for i in range(n):
        start = board[0][i]
        cnt = 1
        for j in range(1, n):
            if board[j][i] == start:
                cnt += 1
                tmp = max(tmp, cnt)
            else:
                start = board[j][i]
                cnt = 1
    return tmp


if __name__ == '__main__':

    n = int(input())

    candy = []
    for _ in range(n):
        candy.append(list(x for x in input()))

    result = 1 # 결과 최대 값
    # 옆에 있는 사탕이랑 바꿀 때
    for x in range(n):
        for y in range(n-1):
            board = copy.deepcopy(candy)
            switchedRight = rightChange(x, y, board)
            result = max(result, hSearch(switchedRight), ySearch(switchedRight))

            switchedDown = downChange(y, x, board)
            result = max(result, hSearch(switchedDown), ySearch(switchedDown))

    print(result)
