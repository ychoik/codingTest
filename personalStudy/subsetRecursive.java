// 부분집합 문제
// 정수 N이 주어졌을 때, 1부터 N까지의 수로 만들 수 있는 모든 부분 집합을 출력하시오. (공집합 제외)

public class subsetRecursive {

    static int N =3;
    static int arr[] = {1,2,3};
    static boolean [] used = new boolean[N];

    public static void main(String[] args)
    {
        dfs(0);
    }

public static void dfs(int depth)
{
    if(depth==N)
    {
        boolean isEmpty = true;

        for(int i=0; i<N;i++)
        {
            if(used[i])
            {
                System.out.print(arr[i]+" ");
                isEmpty = false;
            }


        }

        if(!isEmpty)
        {
            System.out.println();
        }


        return;
    }

    //현재 숫자 뽑는 경우
    used[depth] = true;
    dfs(depth+1);//다음 숫자로 넘어가기

    //현재 숫자 안 뽑는 경우
    used[depth] = false;
    dfs(depth+1);//다른 숫자로 넘어가기


}

}
