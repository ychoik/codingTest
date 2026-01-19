import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class boj_2179_gold4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        String[] original = new String[N];
        String[] sorted = new String[N];

        for (int i = 0; i < N; i++) {
            original[i] = br.readLine();
            sorted[i] = original[i];
        }


        Arrays.sort(sorted);
        int maxLen = 0;

        for (int i = 0; i < N - 1; i++) {
            int len = getCommonLength(sorted[i], sorted[i+1]);
            if (len > maxLen) {
                maxLen = len;
            }
        }

        if (maxLen == 0) {
            System.out.println(original[0]);
            System.out.println(original[1]);
            return;
        }


        HashMap<String, Integer> map = new HashMap<>();

        int bestS = Integer.MAX_VALUE;
        int bestT = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            if (original[i].length() < maxLen) continue;

            String prefix = original[i].substring(0, maxLen);

            if (map.containsKey(prefix)) {

                int sIdx = map.get(prefix);
                int tIdx = i;


                if (sIdx < bestS) {
                    bestS = sIdx;
                    bestT = tIdx;
                }
//                else if (sIdx == bestS) {
//                    // S가 같다면 T가 빠른 것을 선택해야 함
//                    // 하지만 탐색 순서상(i가 증가) 먼저 발견된 것이 T가 더 작으므로 업데이트할 필요 없음
//                    if (tIdx < bestT) {
//                        bestT = tIdx;
//                    }
//                }
            } else {

                map.put(prefix, i);
            }
        }


        System.out.println(original[bestS]);
        System.out.println(original[bestT]);
    }


    private static int getCommonLength(String s1, String s2) {
        int len = 0;
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }
}

