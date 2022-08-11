'''
프로그래머스
블록 이동하기
'''

from collections import deque


def get_next_pos(pos, board):
    # 이동 가능한 위치들을 반환한다.
    next_poses = []
    pos = list(pos)  # 현재 위치 정보를 집합에서 리스트로 변환
    x1, y1, x2, y2 = pos[0][0], pos[0][1], pos[1][0], pos[1][1]

    # 상하좌우로 이동하는 경우에 대해서 처리
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(4):
        next_x1, next_y1, next_x2, next_y2 = x1 + dx[i], y1 + dy[i], x2 + dx[i], y2 + dy[i]
        # 빈칸이라 이동이 가능하다면 next_pos에 추가
        if board[next_x1][next_y1] == 0 and board[next_x2][next_y2] == 0:
            next_poses.append({(next_x1, next_y1), (next_x2, next_y2)})

    # 현재 로봇이 가로로 있는 경우
    if x1 == x2:
        # 위쪽으로 회전 하거나, 아래쪽으로 회전하거나
        for i in [-1, 1]:
            # 위 두 칸, 아래 두칸이 0이라면 회전 가능
            if board[x1 + i][y1] == 0 and board[x2 + i][y2] == 0:
                next_poses.append({(x1, y1), (x1 + i, y1)})  # 왼
                next_poses.append({(x2, y2), (x2 + i, y2)})  # 오
    # 로봇이 세로로 있는 경우
    elif y1 == y2:
        # 왼쪽으로 회전 하거나, 오른쪽으로 회전하거나
        for i in [-1, 1]:
            if board[x1][y1 + i] == 0 and board[x2][y2 + i] == 0:
                next_poses.append({(x1, y1), (x1, y1 + i)})  # 위
                next_poses.append({(x2, y2), (x2, y2 + i)})  # 아래

    # 현재 위치에서 이동할 수 있는 방향리스트 반환
    return next_poses


def solution(board):
    # 맵에 외곽에 벽을 두는 형태로 변경
    n = len(board)
    new_board = [[1] * (n + 2) for _ in range(n + 2)]
    for i in range(n):
        for j in range(n):
            new_board[i + 1][j + 1] = board[i][j]

    # 현재 로봇의 위치를 저장할 테이블을 set으로 하면 순서 구분없이 같은 테이블로 인식
    start = {(1, 1), (1, 2)}  # 시작위치

    q = deque()
    visited = []
    q.append((start, 0))
    visited.append(start)  # 방문처리
    while q:
        now, cost = q.popleft()
        print(now, cost)
        if (n, n) in now:
            return cost

        # 현재 위치에서 이동할 수 있는 위치 확인
        next_move = get_next_pos(now, new_board)

        for next_pos in next_move:
            if next_pos not in visited:  # 방문하지 않은 곳이라면
                q.append((next_pos, cost + 1))
                visited.append(next_pos)  # 방문 처리
    return 0


bo = [[0, 0, 0, 1, 1], [0, 0, 0, 1, 0], [0, 1, 0, 1, 1], [1, 1, 0, 0, 1], [0, 0, 0, 0, 0]]
result = solution(bo)
print(result)
