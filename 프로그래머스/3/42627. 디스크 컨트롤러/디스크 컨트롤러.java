import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 소요시간 > 요청 시각> 번호
        
        int n = jobs.length;
        int arr[][] = new int [n][3];
        //arr[i][0] = 작업번호
        //arr[i][1] = 요청 시각
        //arr[i][2] = 소요 시간
        
        for(int i=0; i<n; i++)
        {
            arr[i][0]=i; //작업번호
            arr[i][1]=jobs[i][0]; //요청 시각
            arr[i][2]=jobs[i][1]; //소요 시간
        }
        
        //요청시각 기준으로 정렬, 요청시각이 같다면 작업 번호가 적은 순서로 정렬
        //이유: 현재 시간까지 요청된 작업만 우선순위 큐에 넣어야 해서
        Arrays.sort(arr, (a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        Queue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[2]!=b[2]){
                return a[2]-b[2];
            }
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        
        int time=0;//현재시간
        int index =0; //아직 우선순위 큐에 넣지 않은 작업 위치
        int count=0; //처리 완료한 작업 개수
        int total=0; //모든 작업의 반환 시간 합
        
        while(count<n){
            
            //현재시간까지 요청된 작업들을 넣기
            while(index<n && arr[index][1]<= time)
            {
                pq.offer(arr[index]);
                index++;
            }
            
            if(pq.isEmpty())//작업이 없는 경우
            {
                time = arr[index][1];
                continue;
            }
            
            int [] job = pq.poll();
            
            int requestTime = job[1]; //요청시각
            int workTime = job[2]; //소요시간
            
            time+= workTime;
            
            total += time - requestTime;
            count++;
            
        }
        
        
        return total/n;
    }
}