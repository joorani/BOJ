'''
완전탐색
가르침


k에서 필수 단어 5개 뺀 수가 추가로 학습할 수 있는 단어의 개수
k-size <0 이면 0을 리턴한다.
소문자 알파벳이 26개니깐 알파벳에서 학습할 수 있는 개수만큼 뽑는다.
주어진 단어들을 돌면서 모든 알파벳이 단어 배열에 포함된 경우 cnt += 1을 한다.
'''
import sys

n, k = map(int, input().split())
words = [set(sys.stdin.readline().rstrip()) for _ in range(n)]  # 주어진 단어들
answer = 0

# 필수로 들어가야하는 단어 anta, tica
first = set("anta")
first.update("tica")

# k가 5보다 작으면 어떠한 단어도 배울수 없음
if k - len(first) < 0:
    print(0)
    sys.exit(0)

elif k == 26:
    print(n)
    sys.exit(0)

learn = [0] * 26
for i in first:
    learn[ord(i) - ord('a')] = 1

def dfs(L, cnt):
    global answer
    if cnt == k - len(first):
        word_cnt = 0
        for word in words:
            flag = True
            for w in word:
                if learn[ord(w)-ord('a')] != 1:
                    flag = False
                    break
            if flag:
                word_cnt += 1
        # 단어 다 확인했을 때
        answer = max(answer, word_cnt)
        return
    else:
        # 중복되면 안되기 때문에 조합으로
        for idx in range(L, 26):
            if learn[idx] == 0:
                learn[idx] = 1
                dfs(idx, cnt + 1)
                learn[idx] = 0  # 안쓰는 경우


dfs(0,0)
print(answer)
