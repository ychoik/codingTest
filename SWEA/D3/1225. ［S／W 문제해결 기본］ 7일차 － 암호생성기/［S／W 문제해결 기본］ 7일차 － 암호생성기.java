import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);

        for (int tc = 0; tc < 10; tc++) {
            int test_case = sc.nextInt();
            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                queue.offer(sc.nextInt());
            }

            int minus = 1;

            // 1. 암호 생성
            while (true) {
                int num = queue.poll();
                num -= minus;

                if (num <= 0) {
                    queue.offer(0);
                    break;
                }

                queue.offer(num);

                minus++;

                if (minus > 5) {
                    minus = 1;
                }
            } 

           
            System.out.print("#" + test_case);

            while (!queue.isEmpty()) {
                System.out.print(" " + queue.poll());
            }

            System.out.println();
        } 

        
        sc.close();
	}
}