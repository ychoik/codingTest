import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<S.length(); i++)
		{

			for(int j=i+1; j<=S.length(); j++)
			{
				set.add(S.substring(i,j));
				//System.out.println(S.substring(i, j)); 
			}
			
		}
		
		System.out.println(set.size());

	}
}