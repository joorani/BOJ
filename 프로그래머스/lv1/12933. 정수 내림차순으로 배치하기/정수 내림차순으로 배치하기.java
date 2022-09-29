import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();

        String[] ll = String.valueOf(n).split("");
        Arrays.sort(ll);

        for (String s : ll) {
            sb.append(s);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
