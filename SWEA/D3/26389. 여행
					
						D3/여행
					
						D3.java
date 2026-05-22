
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String str = sc.nextLine();
            char [] move = new char[str.length()];
            boolean hasN=false, hasW=false, hasE=false, hasS=false;
            for(int i=0; i<str.length(); i++){
             	   move[i] = str.charAt(i);
                	if(move[i]=='N'){
                     	hasN=true;   
                    }
                    else if(move[i]=='W'){
                        hasW=true;
                    }
                    else if(move[i]=='E'){
                        hasE=true;   
                    }
                    else if(move[i]=='S')
                    {
                        hasS=true;
                    }
            }
            
            if((hasN == hasS) && (hasE == hasW)){
             	System.out.println("Yes");
            }
            else{
             	System.out.println("No");
            }
            

            
		}
	}
}