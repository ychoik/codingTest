import java.util.ArrayList;

class Solution_178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int minLength = Integer.MAX_VALUE; // 가장 짧은 길이를 저장할 변수
        int start = 0;
        int currentSum = 0;
        for(int end=0; end<sequence.length; end++)
        {
            currentSum += sequence[end];

            while(currentSum > k)
            {
                currentSum -= sequence[start];
                start++;
            }

            if(currentSum == k)
            {
                int currentLength = end - start;
                if(currentLength < minLength)
                {
                    minLength = currentLength;
                    answer[0] = start;
                    answer[1] = end;
                }
            }

        }

        return answer;


    }
}

public class con_subsequences_178870 {
    public static void main(String[] args) {
        Solution_178870 obj = new Solution_178870();
        System.out.println(obj.solution(new int[]{1,2,3,4,5}, 7));

    }



}
