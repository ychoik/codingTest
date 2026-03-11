import java.util.Scanner;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		StringBuilder result = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		boolean inTag = false;
		
		for(int i=0; i<S.length(); i++)
		{
			char c = S.charAt(i);
			
			if(c=='<')
			{
				result.append(word.reverse());
				word.setLength(0);
				
				inTag = true;
				result.append(c);
				
			}
			else if(c=='>')
			{
				inTag=false;
				result.append(c);
			}
			else if(inTag)
			{
				result.append(c);
			}
			else {
				
				if(c==' ')
				{
					result.append(word.reverse());
					word.setLength(0);
					result.append(' ');
				}
				else {
					word.append(c);
				}
				
			}

		}
		
		result.append(word.reverse());
		
		System.out.println(result);
		
		
	}

}