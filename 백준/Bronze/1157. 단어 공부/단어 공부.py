word = input().upper()
unique_word = list(set(word))

#각 알파벳이 word에서 몇 번 사용되었는지 count해서 list로 저장
cnt_list = []
for w in unique_word:
    cnt = word.count(w)
    cnt_list.append(cnt)

#최대값이 하나인 경우와, 여러 개인 경우 출력 값이 달라진다.
if cnt_list.count(max(cnt_list)) > 1:
    print('?')
else:
    max_idx = cnt_list.index(max(cnt_list))
    print(unique_word[max_idx])