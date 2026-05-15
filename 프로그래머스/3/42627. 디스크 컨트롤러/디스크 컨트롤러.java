import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 우선순위 : 소요시간 > 요청 시각> 번호
        
        int n = jobs.length;
        int arr[][] = new int [n][3];
        //arr[i][0] = 작업번호
        //arr[i][1] = 요청 시각
        //arr[i][2] = 소요 시간
        
        for(int i=0; i<n; i++)
        {
            arr[i][0] = i;
            arr[i][1] = jobs[i][0];
            arr[i][2] = jobs[i][1];
        }
        
        Arrays.sort(arr, (a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1]; // 정렬에서 양수가 나오면 보통 a가 b보다 뒤로 감. 1번째를 기준으로 정렬 
            }
            return a[0] - b[0];//0번째를 기준으로 정렬
        });
        
        Queue<int []> pq = new PriorityQueue<>((a,b)->{
            if(a[2] != b[2]){
                return a[2]-b[2];
            }
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int time =0;
        int index = 0;
        int count =0;
        int total =0;
        
        while(count < n){
            
            while(index < n && arr[index][1] <= time){
                pq.offer(arr[index]);
                index++;
            }
            
            if(pq.isEmpty())
            {
                time = arr[index][1];
                continue;
            }
            
            int [] job = pq.poll();
            
            int requestTime = job[1]; // 요청시각
            int workTime = job[2]; // 소요시간
            
            time += workTime;
            total += time - requestTime;
            count++;
            
        }
        
        return total/n;
        
        
       
    }
}