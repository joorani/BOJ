class Solution {
   public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int a = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                a = absolutes[i];
            } else {
                a = -absolutes[i];
            }
            answer += a;
        }
        
        return answer;
    }
}