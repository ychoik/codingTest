import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<String> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        q.offer(begin);

        // 큐에 탐색할 단어가 남아 있는 동안 반복
        while (!q.isEmpty()) {
            // 현재 단계에서 처리할 단어 개수
            int size = q.size();

            for (int k = 0; k < size; k++) {
                String current = q.poll();

                // 목표 단어에 도착하면 최소 변환 횟수 반환
                if (current.equals(target)) {
                    return answer;
                }

                for (int i = 0; i < words.length; i++) {
                    // 이미 방문한 단어는 건너뛰기
                    if (visited[i]) continue;

                    int diff = 0;

                    // 서로 다른 글자의 개수 세기
                    for (int j = 0; j < current.length(); j++) {
                        if (current.charAt(j) != words[i].charAt(j)) {
                            diff++;
                        }
                    }

                    // 한 글자만 다르면 다음 단계에서 탐색
                    if (diff == 1) {
                        visited[i] = true;
                        q.offer(words[i]);
                    }
                }
            }

            // 현재 단계의 단어들을 모두 처리한 뒤 증가
            answer++;
        }

        return 0; // 목표 단어에 도달하지 못한 경우
    }
}