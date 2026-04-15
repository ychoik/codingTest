import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = 1<<N;
        int answer = 0;

        while(size > 1)
        {
            int half = size/2;
            int area = half*half;

            if(r<half && c<half){

            }
            else if(r<half && c>=half){
                answer += area;
                c-=half;
            }
            else if(r>=half && c<half)
            {
                answer+=area*2;
                r-=half;
            }
            else
            {
                answer+=area*3;
                r-=half;
                c-=half;
            }
            size = half;

        }
        System.out.println(answer);

    }
}
