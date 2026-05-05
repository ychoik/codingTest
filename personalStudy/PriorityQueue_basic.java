import java.util.*;
public class PriorityQueue_basic {
    public static void main(String args[]){
      Queue<Integer>pq = new PriorityQueue<>();//기본은 최소 힙
      Queue<Integer>pq2 = new PriorityQueue<>(Collections.reverseOrder());

      pq.add(3);
      pq2.add(3);
      pq.add(1);
      pq2.add(1);
      pq.add(2);
      pq2.add(2);

      System.out.println(pq.poll());//작은 것 부터 나옴
        System.out.println(pq2.poll());//큰 것부터 나옴


    }
}
