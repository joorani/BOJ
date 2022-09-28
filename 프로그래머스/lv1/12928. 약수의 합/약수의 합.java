import java.util.HashSet;
import java.util.stream.Stream;

class Solution {
    // int answer 변수에 나오는 약수들을 더해주면 된다. 굳이 컬렉션까지 쓸 일이 아니었다.
    public int solution(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                hashSet.add(i);
                hashSet.add(n/i);
            }
        }
        
        return hashSet.stream().mapToInt(Integer::intValue).sum();
    }
}