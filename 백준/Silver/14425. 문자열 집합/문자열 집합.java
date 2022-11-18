
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        tNode root = new tNode();
        while (n > 0) {
            String text = sc.next();
            tNode now = root; //현재 노드를 루트 노드로 지정
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode(); //공백상태이면 노드 새로 생성
                }
                now = now.next[c-'a'];
                //문자열의 마지막일때
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            n--;
        }

        int count = 0;
        //트라이 자료구조 검색하기
        while (m > 0) {
            String text = sc.next();
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break; // 공백노드라면 이 문자열을 포함하지 않음
                }
                now = now.next[c-'a'];
                if (i == text.length() - 1 && now.isEnd) {
                    count ++;
                }
            }
            m--;
        }
        System.out.println(count);
    }
}

class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd;
}

