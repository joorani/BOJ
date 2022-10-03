class Solution {
    public String solution(String s) {
        String answer = "";
        //짝수
        int midIdx = s.length() / 2;
        if (s.length() % 2 == 0) {
            answer = s.substring(midIdx - 1, midIdx + 1);
        } else {
            answer = s.substring(midIdx, midIdx+1);
        }
        return answer;
    }
}