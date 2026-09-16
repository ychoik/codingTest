
import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			List<Integer>[] graph = new ArrayList[V+1];
			
			for(int i=0; i<=V; i++)
			{
				graph[i] = new ArrayList<>();
			}
			
			int [] indegree = new int[V+1]; //선행 조건
			
			for(int i=0; i<E; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				graph[a].add(b); //a->b
				indegree[b]++; //b 선행 조건 증가				
				
			}
			
			Queue<Integer>queue = new ArrayDeque<>();
			
			for(int i=1; i<=V; i++) {
				if(indegree[i]==0)
				{
					queue.offer(i);
				}
			}
			
			StringBuilder result = new StringBuilder();
			result.append("#").append(test_case);
			
			while(!queue.isEmpty()) {
				int current = queue.poll();
				result.append(" ").append(current);
				
				for(int next: graph[current]) {
					indegree[next]--;
					
					
					if(indegree[next]==0) {
						queue.offer(next);
					}
					
				}
				
				
				
			}
			
			
			System.out.println(result);
			
			
			
		}
	
	}
}