import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();

        int k=0;
        for(int i=0; i<N; i++)
        {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], k++);

            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(map.get(nums[i])).append(' ');
        }

        System.out.println(sb);


    }
}