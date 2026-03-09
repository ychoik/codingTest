import java.io.*;

class Node
{
	int data;
	Node left; 
	Node right;
	
	Node(int data)
	{
		this.data=data;
	}
	
	Node(int data, Node left, Node right)
	{
		this.data= data;
		this.left = left;
		this.right = right;
		
	}
	
}


public class Main {
	static Node root = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num;
		while(true)
		{
			
			num=br.readLine();
			if (num == null || num.equals(""))
                break;
			
			insert(Integer.parseInt(num));
		}
		
		Post(root);
	}
	static void insert(int data)
	{
		if(root==null)
		{
			root=new Node(data);
		}
		else
		{
			Node cur = root;
			while(true)
			{
				if(data<cur.data)//데이터 비교, 작으면 왼쪽으로 내려가기
				{
					if(cur.left == null)
					{
						cur.left = new Node(data);
						break;
					}
					
					cur=cur.left;
					
				}
				else
				{
					if(cur.right == null)
					{
						cur.right = new Node(data);
						break;
					}
					
					cur=cur.right;
					
				}
				
			}
			
		}
		
		
		
	}
	
	static void Post(Node cur)
	{
		
		if(cur==null)
		{
			return;
		}
		
		Post(cur.left);
		
		Post(cur.right);
		System.out.println(cur.data);
	}

}