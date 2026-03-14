import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] left = new int[N+1];

        for(int i = 1; i<N; i++)
        {
            left[i] = sc.nextInt();
        }

        int line[] = new int[N];

        for(int height = 1; height<=N; height++)
        {
            int count =0; // 빈 자리 개수

            for(int i=0; i<N; i++){
                if(line[i]==0)
                {
                    if(count == left[height])
                    {
                        line[i] = height;
                        break;
                    }
                    count++;
                }
            }

        }

        for(int i=0; i<N; i++){
            System.out.print(line[i] +" ");
        }


    }
}