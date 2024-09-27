package L4AmazonMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class findClosestElements {

    public static List<Integer> findClosestElement(int arr[], int k, int x) {
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.add(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.add(integer);
            }
        }
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll());
        }

        return ans;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;
        List<Integer> ans = findClosestElement(arr, k, x);
        for (int integer : ans) {
            System.out.print(integer + " ");
        }
    }
}
