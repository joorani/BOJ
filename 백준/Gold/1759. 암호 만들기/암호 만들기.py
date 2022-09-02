'''
모음 최소 1, 최소 2개 자음

모든 가능한 경우의 수를 구하고 그 수가 조건을 만족하는 지 확인?
'''


def DFS(id, st):
    if id == L:
        # 조건이 만족하는지 확인
        if check(res):
            print(''.join(res))
            return
    else:
        for i in range(st, c):
            if ch[i] == 0:
                ch[i] = 1
                res[id] = alpha[i]
                DFS(id + 1, i + 1)
                ch[i] = 0


def check(arr):
    arr.sort()
    result = False
    vowel = ['a', 'e', 'i', 'o', 'u']  # 모음
    mo_cnt = 0
    ja_cnt = 0
    for x in arr:
        if x in vowel:
            mo_cnt += 1
        else:
            ja_cnt += 1
    if mo_cnt >= 1 and ja_cnt >= 2:
        result = True
    return result


if __name__ == '__main__':
    L, c = map(int, input().split())
    alpha = list(input().split())
    res = [0] * L  # 결과값 담을 테이블
    alpha.sort()
    ch = [0] * c
    DFS(0,0)
