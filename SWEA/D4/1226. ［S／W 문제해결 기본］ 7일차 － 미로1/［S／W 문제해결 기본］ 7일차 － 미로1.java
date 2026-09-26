import java.util.*;

class Solution
{
    static char[][] maze;
    static boolean[][] visited;

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    static boolean dfs(int x, int y){

        if(maze[x][y]=='3'){
            return true;
        }

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx >=16 || ny<0 || ny>=16){
                continue;
            }

            if(maze[nx][ny]!= '1' && !visited[nx][ny]){
                if(dfs(nx,ny)){
                    return true;
                }
            }

        }

        return false;


    }
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);

       for (int tc = 1; tc <= 10; tc++) {

            int testCase = sc.nextInt();

            maze = new char[16][16];
            visited = new boolean[16][16];

            int startX = 0;
            int startY = 0;

            
            for (int i = 0; i < 16; i++) {

                String line = sc.next();

                for (int j = 0; j < 16; j++) {

                    maze[i][j] = line.charAt(j);

                    
                    if (maze[i][j] == '2') {
                        startX = i;
                        startY = j;
                    }
                }
            }


            boolean result = dfs(startX, startY);

            System.out.println("#" + testCase + " " + (result ? 1 : 0));
        }



    }
}