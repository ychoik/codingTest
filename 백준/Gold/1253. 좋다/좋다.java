import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] A = new int[N];

        for(int i=0; i<N; i++)
        {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int cnt =0; // 좋은 수의 갯수
        for(int k=0; k<N; k++)
        {
            int left =0;
            int right =N-1;
            int target = A[k];

            while(left < right)
            {
                if(left ==k)
                {
                    left++;
                    continue;
                }
                if(right ==k)
                {
                    right--;
                    continue;
                }

                int sum = A[left]+A[right];

                if(sum==target)
                {
                    cnt++;
                    break;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }

            }

        }

        System.out.println(cnt);



    }
}