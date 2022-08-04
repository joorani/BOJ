def solution(N, stages):
    # 도전한 유저의 수
    users = len(stages)

    result =[] #결과 값을 담을 테이블, 실패율과 스테이지번호를 튜플 형태로 저장
    participant = [0]*(N+1) # 참석자 수를 저장할 테이블
    for stage in stages:
        if stage > N:
            continue
        if stage <= N:
            participant[stage] += 1

      #실패율 구하기
    for stage_num in range(1, N+1):
        
        fail = participant[stage_num] / users if users != 0 else 0
        result.append((stage_num, fail))
        users -= participant[stage_num]
      


    # 실패율 순으로 내림차순 정렬
    result.sort(key= lambda x: -x[1])

    # 각 스테이지 번호 출력
    answer = []
    for x in result:
        answer.append(x[0])

    return answer