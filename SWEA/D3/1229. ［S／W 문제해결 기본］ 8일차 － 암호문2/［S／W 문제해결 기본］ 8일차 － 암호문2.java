import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n= sc.nextInt();
			List<Integer> password = new ArrayList<>();
			
			for(int i=0; i<n; i++)
			{
				password.add(sc.nextInt());
			}
			
			int command_num = sc.nextInt();
			
			for(int i=0; i<command_num; i++)
			{
				String command = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(command.equals("I")) {
					for(int j=0; j<y; j++)
					{
						int s = sc.nextInt();
						password.add(x+j, s);
					}
				}else if(command.equals("D")){
					for(int j=0; j<y; j++)
					{
						password.remove(x);
					}
				}

			
		}
			// 4. 모든 명령을 처리한 뒤 앞의 10개 출력
			System.out.print("#" + test_case);
			
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + password.get(i));
			}
			
			System.out.println();
		}
	}
}