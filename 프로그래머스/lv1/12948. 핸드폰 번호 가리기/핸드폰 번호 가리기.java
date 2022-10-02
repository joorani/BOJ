import java.util.Arrays;

class Solution {
    public String solution(String phone_number) {

        String[] split = phone_number.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length - 4;i++) {
            split[i] = "*";
        }

        Arrays.stream(split).forEach(x -> sb.append(x));
        return sb.toString();
    }
}