'''
괄호 변환

1. 올바른 문자열인지 아닌지 판단한다.
    1-1. 올바른 문자열인 경우 그대로 반환한다.
    1-2. 올바른 문자열이 아닌 경우 2번으로 간다.
2.
'''

def solution(p):

    answer = ''
    # 빈 문자열인 경우 빈 문자열 반환
    if p == '':
        return answer
    idx = balanced_index(p) #인덱스를 기준으로 u와 v로 나눈다.
    u = p[:idx+1]
    v = p[idx+1:]

    #u가 올바른 문자열인지 판단
    # 올바른 문자열이면 v에 대해 함수를 수행한 결과를 반환
    if check_right(u):
        answer = u+solution(v)
    # 올바른 문자열 아닌 경우
    else:
        answer  = '('
        answer += solution(v)
        answer += ')'
        # u의 첫번쨰와 마지막 문자 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 붙인다.
        u = list(u[1:len(u)-1])
        for i in range(len(u)):
            if u[i] == '(':
                u[i]= ')'
            else:
                u[i] = '('
        answer += "".join(u)
    return answer






#균형잡힌 문자열로 분리하는 함수 - 인덱스 반환
def balanced_index(p):
    count = 0 #왼쪽 괄호 개수
    for i in range(len(p)):
        if p[i] == '(':
            count+= 1
        else:
            count -= 1
        if count == 0:
            return i

# 올바른 문자열인지 판단
def check_right(s):
    count = 0 # 왼쪽 괄호 개수
    for i in s:
        # 무조건 '(' 먼저 나와야함. / ')' 먼저 나오면 false 리턴
        if i == '(':
            count+= 1
        else:
            if count == 0:
                return False
            count -= 1
    return True


