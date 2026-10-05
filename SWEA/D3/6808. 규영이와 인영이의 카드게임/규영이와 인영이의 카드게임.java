import java.io.*;
import java.util.*;

/*
 규영이는 입력받은 대로 순서 고정, 인영이는 카드 순서 바꿀 수 있다. 
인영이의 카드 순서만 모두 만들어 보면 된다. -> 내는 순서에 따라 카드가 달라지므로 순열이다. + 순서가 중요하다

모든 경우를 확인할 수 있는지 계산해야 한다. 
인영이의 카드는 9장. 가능한 순서는 9! ->완전탐색으로 풀어보기.

인영이 카드 준비하기. -> 규영이가 가진 9장 제외한 나머지 9장 배열에 저장. 

재귀로 한 라운드씩 진행. -> dfs
하나의 선택이 다음 선택까지 이어지니까 dfs.
 */


public class Solution {

    static int [] gyu;
    static int [] in;
    static boolean[] visited; //인영이 카드 사용 여부. 
    static int win, lose; //규영이 승리 ,패배 횟수

    static void dfs(int round, int gyuScore, int inScore){

        if(round == 9){//9라운드가 끝나면 최종 점수 비교.
            if(gyuScore>inScore){
                win++;
            }else if(gyuScore<inScore){
                lose++;
            }
            return;
        }

        for(int i=0; i<9; i++)//이번 라운드에 낼 인영이 카드 선택
        {
            if(visited[i]) continue;

            visited[i]=true;
            int score = gyu[round] + in[i];

            if(gyu[round]>in[i]){ // 큰 카드를 낸 사람에게 두 카드 합 더하기. 
                dfs(round+1, gyuScore+score, inScore);
            }else{
                dfs(round+1, gyuScore, inScore+score);
            }

            visited[i] = false;

        }

    }
    public static void main(String argd[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for(int tc = 1; tc<=T; tc++)
        {
            gyu = new int[9];
            in = new int[9];
            visited = new boolean[9];
            win = 0;
            lose =0;

            boolean[] hasCard = new boolean[19];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<9; i++)
            {
                gyu[i] = Integer.parseInt(st.nextToken());
                hasCard[gyu[i]]=true;
            }


            int index =0;

            for(int card =1; card<=18; card++)
            {
                if(!hasCard[card]){
                    in[index++] = card; //규영이가 갖지 않은 인영이 카드
                }
            }

            dfs(0,0,0);

            System.out.println("#" + tc + " " + win + " " + lose);




        }
        br.close();

    }
    
}
