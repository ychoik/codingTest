import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
			String[] cards = new String[N];

			for(int i=0; i<N; i++){
				cards[i] = sc.next();
			}

			int half = (N+1)/2;

			System.out.print("#" + test_case);

			for(int i=0; i<half; i++)
			{
				System.out.print(" " + cards[i]);

				if(half + i<N){
					System.out.print(" " + cards[half+i]);
				}

			}
			System.out.println();

		}
	}
}