'''

중복 없이 m개를 고른 수열

'''
def DFS(L):
    if L == m:
        for num in res:
            print(num, end= ' ')
        print()
    else:
        for i in range(1, n+1):
            if checked[i] == 0:
                res[L] = i
                checked[i] = 1
                DFS(L+1)
                checked[i] = 0

#입력받기
if __name__ == '__main__':

    n, m = map(int, input().split())

    checked = [0] * (n+1) # 중복이 되면 안되므로 사용한 수는 체크
    res = [0] * m # 수열을 저장할 배열
    DFS(0)
