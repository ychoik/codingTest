
class Solution_178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        answer=new int[2];
        int x=0;
        int start=0;
        int end=0;
        for(int i=0; i<sequence.length; i++)
        {
            x=sequence[i];
            for(int j=i+1; j<sequence.length; j++)
            {
                x+=sequence[j];
                if(x>k)
                {
                    break;
                }
                else if(x==k)
                {
                    start = i;
                    end = j;
                }
            }
        }

        answer[0] = start;
        answer[1] = end;

        return answer;


    }
}

public class con_subsequences_178870 {
    public static void main(String[] args) {
        Solution_178870 obj = new Solution_178870();
        System.out.println(obj.solution(new int[]{1,2,3,4,5}, 7));

    }



}
