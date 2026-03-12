import java.util.Arrays;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();

            int minSix = Integer.MAX_VALUE;
            int minOne = Integer.MAX_VALUE;

            int[] six = new int[M];
            int[] one = new int[M];

            int result=0;

            for (int i = 0; i < M; i++) {
                six[i] = sc.nextInt();
                one[i] = sc.nextInt();
            }

            Arrays.sort(six);
            Arrays.sort(one);

            int case1 = N*one[0];
            int case2 = (N/6)*six[0] + (N%6)*one[0];
            int case3 = ((N/6)+1)*six[0];

            result = Math.min(case1, Math.min(case2, case3));

            System.out.println(result);
        }

}