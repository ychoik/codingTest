import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        int B[] = new int[N];

        for(int i=0; i<N; i++)
        {
            A[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++)
        {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<B.length/2; i++)
        {
            int temp = B[i];
            B[i]=B[B.length-1-i];
            B[B.length-1-i] = temp;
        }

        int S = 0;

        for(int i=0; i<N; i++)
        {
            S += A[i]*B[i];
        }

        System.out.println(S);

    }
}