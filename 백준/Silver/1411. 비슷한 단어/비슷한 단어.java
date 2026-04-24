import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] pattern = new String[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            // 단어마다 문자 대응 관계가 새로 시작되어야 함
            Map<Character, Integer> map = new HashMap<>();

            StringBuilder sb = new StringBuilder();
            int x = 0;

            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);

                // 처음 나온 문자면 번호 부여
                if (!map.containsKey(ch)) {
                    map.put(ch, x++);
                }

                // 현재 문자의 번호를 패턴에 저장
                sb.append(map.get(ch)).append(",");
            }

            pattern[i] = sb.toString();
        }

        int count = 0;

        // 모든 단어 쌍 비교
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (pattern[i].equals(pattern[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }


}
