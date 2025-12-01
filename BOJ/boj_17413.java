import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_17413 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean inTag = false; // 현재 태그 내부인지 여부 (< > 사이)

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '<') {
                // 단어가 있으면 뒤집어서 출력
                result.append(word.reverse());
                word.setLength(0); // 버퍼 비우기

                inTag = true;
                result.append(c); // '<' 출력
            }
            else if (c == '>') {
                inTag = false;
                result.append(c); // '>' 출력
            }
            else if (inTag) {
                // 태그 내부는 그대로 출력
                result.append(c);
            }
            else {
                // 태그 외부(단어 뒤집기 구역)
                if (c == ' ') {
                    // 단어 하나 끝났다면 뒤집어서 출력
                    result.append(word.reverse());
                    word.setLength(0);
                    result.append(' '); // 공백 그대로 출력
                } else {
                    // 단어는 반대로 저장
                    word.append(c);
                }
            }
        }

        // 마지막 단어 처리
        result.append(word.reverse());

        System.out.println(result);
    }
}
