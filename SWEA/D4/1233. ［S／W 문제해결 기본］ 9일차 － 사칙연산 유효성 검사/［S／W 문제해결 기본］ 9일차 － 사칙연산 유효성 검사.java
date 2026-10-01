import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			
			boolean valid = true;
			
			for(int i=0; i<N; i++)
			{
				String[] input = sc.nextLine().split(" ");
				
				String value = input[1];
				
				if(input.length==4) { //자식이 있는 노드
					if(Character.isDigit(value.charAt(0))) {//자식이 있는데 숫자인 경우는 잘못된 것
						valid = false;
					}
				}
				else if(input.length ==2) {//자식이 없는 노드
					if(!Character.isDigit(value.charAt(0))) {
						valid = false;
					}
				}
				
				else {//입력이 3개면 자식이 1개라서 잘못된 식
					valid = false;
				}
			}
			
			if(valid) {
				System.out.println("#"+tc+" 1");
			} else {
				System.out.println("#"+tc+" 0");
			}
		}
		
		sc.close();
	}

}
