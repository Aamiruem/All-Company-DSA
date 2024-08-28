import java.util.Collections; 
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int stones[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        // for(int i=0;i<stones.length;i++){
        //     pq.add(stones[i]);
        // }
        //or
        for(int x : stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            if(first!=second){
                pq.add(Math.abs(first-second));
            }
        }
        int i = pq.isEmpty()?0:pq.poll();
        return i;
    }

    public static void main(String[] args) {
        int stones[] = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));
    }
}
