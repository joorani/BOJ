import java.util.Arrays;
class Solution {
    public String solution(String[] seoul) {
        int x= Arrays.asList(seoul).indexOf("Kim");
//        for (int i = 0; i < seoul.length; i++) {
//            if (seoul[i].equals("Kim")) {
//                x = i;
//                break;
//            }
//        }
        String answer = "김서방은 " + x + "에 있다";
        return answer;
    }
}