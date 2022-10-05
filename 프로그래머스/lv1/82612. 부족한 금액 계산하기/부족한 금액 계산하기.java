class Solution {
    public long solution(int price, int money, int count) {
        long m = money;
        while (count != 0) {
            long sum = price * count;
                m -= sum;
            count --;
        }
        return m>0? 0: m*-1;
    }
}