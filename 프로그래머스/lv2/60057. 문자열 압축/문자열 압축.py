def solution(s):
    answer = len(s)
    for step in range(1, len(s) // 2 + 1):
        prev = s[0: step]
        cnt = 1
        compressed = ""
        for i in range(step, len(s), step):
            # 다음 문자가 이전 문자와 같은 경우
            if prev == s[i:i+step]:
                cnt += 1
            # 다른 문자열이 나오는 경우
            else:
                compressed += str(cnt) + prev if cnt>= 2 else prev
                cnt = 1
                prev = s[i:i+step]

        # 남은 문자열 처리
        compressed += str(cnt) + prev if cnt>= 2 else prev
        # 문자열 길이가 더 짧으면 결과값을 변경해준다.

        answer = min(len(compressed), answer)
    return answer