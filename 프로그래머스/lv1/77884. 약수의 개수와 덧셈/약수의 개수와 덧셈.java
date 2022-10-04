class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            answer += i * (isOdd(i) ? -1 : 1);
        }
        return answer;
    }

    //약수의 개수가 홀수인지 짝수인지 확인하는 함수(홀수는 true, 짝수는 false)
    public boolean isOdd(int n) {
        int cnt = 1;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                cnt+= 1;
            }
        }
        return cnt % 2 != 0? true:false;
    }
}