
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		 int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int num = i;
            int clap = 0;

            while (num > 0) {
                int digit = num % 10;

                if (digit == 3 || digit == 6 || digit == 9) {
                    clap++;
                }

                num /= 10;
            }

            if (clap > 0) {
                for (int j = 0; j < clap; j++) {
                    System.out.print("-");
                }
            } else {
                System.out.print(i);
            }

            System.out.print(" ");
		}
	}
}
