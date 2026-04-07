/*
        1. DFS 문제
        문제: 안전 구역의 개수

        N x M 크기의 지도가 주어진다.
        지도에는 0과 1이 들어있다.

        1은 땅
        0은 물

        상하좌우로 연결된 땅들을 하나의 안전 구역이라고 할 때,
        전체 안전 구역의 개수를 구하시오.

        입력 예시
        4 5
        1 1 0 0 1
        0 1 0 1 1
        0 0 0 0 0
        1 1 0 1 0

        출력 예시
        4
 */

import java.util.*;
import java.io.*;
public class dfs_basic_2 {
    static int [][] map;
    static int N, M;
    static boolean visited[][];

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    static void dfs(int x, int y){
        visited[x][y]=true;

        for(int i=0; i<4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M)
            {
                continue;
            }

            if(!visited[nx][ny] && map[nx][ny]==1)
            {
                dfs(nx, ny);
            }

        }


    }

    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt =0; //안전한 영역 갯수 확인

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(!visited[i][j] && map[i][j]==1)
                {
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
