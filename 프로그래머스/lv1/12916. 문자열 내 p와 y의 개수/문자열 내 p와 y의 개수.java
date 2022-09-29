class Solution {
   boolean solution(String s) {

        System.out.println(s);
        int count = 0;
        boolean result = true;


        String[] array = s.toLowerCase().split("");
        for (int i = 0; i <array.length; i++) {
            if ("p".equals(array[i])) {
                count ++;
            } else if ("y".equals(array[i])) {
                count --;
            }
        }
        if (count != 0)
            result = false;

        return result;
    }
}