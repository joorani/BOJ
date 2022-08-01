'''
구현
<2020 카카오 신입 공채>
자물쇠와 열쇠
'''

# 2차원 리스트 90도 회전
def rotate_a_matrix_by_90_degree(a):
    n = len(a) # 행 길이 계산
    m = len(a[0]) # 열 길이 계산
    result = [[0] * n for _ in range(m)] # 결과 리스트
    for i in range(n):
        for j in range(m):
            result[j][n-1-i] = a[i][j]
    return result

# 자물쇠와 key가 맞는지 확인
def isCheck(new_lock):
    lock_length = len(new_lock) // 3
    for i in range(lock_length, lock_length * 2):
        for j in range(lock_length, lock_length *2):
            if new_lock[i][j] != 1:
                return False
    return True

def solution(key, lock):
    n = len(lock) # 자물쇠 길이
    m = len(key) # k의 길이

    # 자물쇠의 크기를 기존의 3배로 변환
    new_lock = [[0] * (n*3) for _ in range(n*3)]

    # 새로운 자물쇠 중앙에 기존 자물쇠 넣기
    for i in range(n):
        for j in range(n):
            new_lock[i+n][j+n] = lock[i][j]

    # 4가지 방향에 대해서 확인
    for rotation in range(4):
        #열쇠 회전
        key = rotate_a_matrix_by_90_degree(key)
        for x in range(n*2):
            for y in range(n*2):
                # 자물쇠에 열쇠 끼워 넣기
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j] += key[i][j]
                        
                # 새로운 자물쇠에 열쇠가 맞는지 확인
                if isCheck(new_lock):
                    return True
                # 자물쇠에서 열쇠를 다시 빼기
                for i in range(m):
                    for j in range(m):
                        new_lock[x+i][y+j] -= key[i][j]
                        
    return False