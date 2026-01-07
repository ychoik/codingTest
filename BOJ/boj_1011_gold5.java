import java.util.Scanner;

public class boj_1011_gold5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

            while (T-- > 0) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                long d = y - x;

                // n = floor(sqrt(d))를 반복문으로 찾기(원하면 Math.sqrt 써도 됨)
                long n = (long) Math.sqrt(d); // 이 줄을 빼고 아래 while만으로도 가능

                // 오차 보정 (안전)
                while ((n + 1) * (n + 1) <= d) n++;
                while (n * n > d) n--;

                long ans;
                if (d == n * n) ans = 2 * n - 1;
                else if (d <= n * n + n) ans = 2 * n;
                else ans = 2 * n + 1;

                System.out.println(ans);
            }


        }

    }
