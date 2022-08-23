'''
# 조합 0의 개수
- 메모리 제한 때문에 메모제이션 불가하다.
- n! // m! * (n-m)! -> 런타임에러남.
문제에서 끝자리가 0이 되는 경우에 0의 개수를 출력하라고 했다.
끝자리가 0이 되는 경우는 소인수 중에서 2, 5의 한쌍이 있으면 0이 추가된다.
그래서 2의 승수와 5의 승수를 구하여 그 중 작은 값을 반환하면 된다.

'''



# n에서의 m의 승수
def count(n, m):
    cnt = 0
    while (n>=m):
        cnt += n//m
        n = n//m
    return cnt

a, b = map(int, input().split())
son = [count(a, 2), count(a, 5)] #분자
parent = [count(a-b, 2) + count(b, 2), count(a-b, 5)+ count(b, 5)] # 분모

# 분자와 분모 각각 2의 승수, 5의 승수끼리 빼준다.
total = [son[0]-parent[0], son[1]-parent[1]]
print(min(total))
