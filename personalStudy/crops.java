public class crops {
    public int[] solution(int[][] crops) {
        int cols = crops[0].length;
        int rows = crops.length;

        int[] answer = new int[cols];

        for (int i = 0; i < cols; i++) {
            int max = Integer.MIN_VALUE;
            int best = -1;
            boolean tie = false;

            for (int j = 0; j < rows; j++) {
                int val = crops[j][i];

                if (val > max) {
                    max = val;
                    best = j;
                    tie = false;        // 새로운 최대값이므로 동점 해제
                } else if (val == max) {
                    tie = true;         // 현재 최대값과 동점 발생
                }
            }

            answer[i] = tie ? -1 : best;
        }

        return answer;
    }
    public static void main(String[] args) {
        crops crops = new crops();
        System.out.println();
    }
}
