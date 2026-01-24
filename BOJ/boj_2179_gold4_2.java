//1. 가장 먼저 사전 순으로 정렬하기 -> 그럼 인접한 것들끼리 접두사가 반복된다.
//2. 정렬된 배열에서는 접두사 최대 길이 알아내자. -> 원본 배열에서 그 길이를 가진 첫 번째 쌍을 찾아내자.
//원본 배열을 그대로 놔둬야 하는 이유는 입력 순서대로 가장 앞선 것을 알아내기 위함.(문제 조건)



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class boj_2179_gold4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] original = new String[N];
        String[] sorted = new String[N];

        for(int i = 0; i < N; i++) {
            original[i] = br.readLine();
            sorted[i] = original[i];
        }

        Arrays.sort(sorted);

        int maxLen=0;
        for(int i = 0; i < N; i++) {
            int len= getCommonLength(sorted[i], sorted[i+1]);
            if(len > maxLen) maxLen = len;

        }


        if(maxLen==0)
        {
            System.out.println(original[0]);
            System.out.println(original[1]);
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();

        int bestS = Integer.MAX_VALUE;
        int bestT = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            if(original[i].length()<maxLen) { continue;}

            String prefix = original[i].substring(0, maxLen);

            if(map.containsKey(prefix)) {
                int sIdx = map.get(prefix);
                int tIdx = i;

                if(sIdx < bestS)
                {
                    bestS = sIdx;
                    bestT = tIdx;
                }


            }
            else{
                map.put(prefix,i);
            }


        }

        System.out.println(original[bestS]);
        System.out.println(original[bestT]);

    }

    public static int getCommonLength(String a, String b) {
        int len=0;
        int minLen = Math.min(a.length(), b.length());
        for(int i=0; i<minLen; i++) {
            if(a.charAt(i)==b.charAt(i)) {
                len++;
            }
            else break;
        }


        return len;
    }

}
