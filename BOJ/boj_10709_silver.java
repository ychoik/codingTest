import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10709_silver {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        String input [][] = new String [H][W];

        for(int i=0; i<H; i++)
        {
            String line = br.readLine();
            int lastCloud = -1;

            for(int j=0; j<W; j++)
            {
                char ch = line.charAt(j);
                int ans;

                if(ch=='c')
                {
                    lastCloud=j;
                    ans=0;
                }
                else {
                    ans=(lastCloud == -1) ? -1 : (j-lastCloud);
                }

                sb.append(ans);
                if(j<W-1) {
                    sb.append(' ');
                }
            }

            if(i<H-1) {
                sb.append("\n");
            }

        }


        System.out.println(sb.toString());



    }
}
