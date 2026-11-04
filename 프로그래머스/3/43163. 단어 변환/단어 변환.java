import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.offer(begin);

        while (!q.isEmpty()) {
            // 현재 단계에서 꺼낼 단어 개수
            int size = q.size();

            // 같은 변환 횟수의 단어들을 모두 처리
            for (int k = 0; k < size; k++) {
                String current = q.poll();

                // 목표 단어에 도착하면 변환 횟수 반환
                if (current.equals(target)) {
                    return answer;
                }

                for (int i = 0; i < words.length; i++) {
                    // 이미 방문한 단어는 건너뛰기
                    if (visited[i]) continue;

                    int diff = 0;

                    // 현재 단어와 몇 글자가 다른지 확인
                    for (int j = 0; j < current.length(); j++) {
                        if (current.charAt(j) != words[i].charAt(j)) {
                            diff++;
                        }
                    }

                    // 한 글자만 다르면 변환 가능
                    if (diff == 1) {
                        visited[i] = true; // 큐에 넣을 때 방문 표시
                        q.offer(words[i]);
                    }
                }
            }

            // 현재 단계의 단어들을 모두 처리한 뒤 증가
            answer++;
        }

        return 0; // 목표 단어로 변환할 수 없는 경우
    }
}