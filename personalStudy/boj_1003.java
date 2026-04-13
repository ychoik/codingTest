import java.io.*;

public class boj_1003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //N은 최대 40이므로 41칸 만들면 0~40까지 사용가능
        int [][] dp = new int[41][2];

        //초기값 설정하기
        dp[0][0]=1;
        dp[0][1]=0;

        dp[1][0]=0;
        dp[1][1]=1;

        for(int i=2; i<=40; i++)
        {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-1][1];
        }

        for(int i=0; i<T; i++)
        {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");

        }
        System.out.println(sb);
    }
}
