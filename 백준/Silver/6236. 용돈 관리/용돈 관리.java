import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] money = new int[N];
        int left=0;
        int right=0;

        for(int i=0; i<N; i++)
        {
            money[i] = Integer.parseInt(br.readLine());

            left = Math.max(left, money[i]);
            right += money[i];

        }
        int answer = right;

        while(left <= right)
        {
            int mid = (left+right)/2;

            int cnt =1;
            int balance = mid;

            for(int i=0; i<N; i++){

                if(balance < money[i])
                {
                    cnt++;
                    balance=mid;
                }
                balance -= money[i];

            }
            if(cnt<=M)
            {
                answer = mid;
                right = mid -1;
            }else{
                left = mid+1;
            }

        }

        System.out.println(answer);


    }
}
