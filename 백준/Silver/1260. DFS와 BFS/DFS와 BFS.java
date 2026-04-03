import java.io.*;
import java.util.*;

public class Main {

    static boolean visited[];
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int start){
        visited[start]=true;
        sb.append(start).append(" ");

        for(int next : graph[start])
        {
            if(!visited[next])
            {
                dfs(next);
            }
        }

    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        visited[start]=true;
        q.offer(start);

        while(!q.isEmpty())
        {
            int now= q.poll();

            sb.append(now).append(" ");

            for(int next : graph[now])
            {
                if(!visited[next])
                {
                    visited[next]=true;

                    q.offer(next);
                }
            }


        }



    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
        {
            graph[i]=new ArrayList<>();
        }


        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);

        }

        for(int i=1; i<=N; i++)
        {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        //--------------

        visited= new boolean[N+1];

        bfs(V);

        System.out.println(sb);

    }
}