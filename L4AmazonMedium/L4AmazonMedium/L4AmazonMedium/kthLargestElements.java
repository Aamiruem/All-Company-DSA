
//pahle array ko sort karenge { 3, 2, 1, 5, 6, 4 }; jo ki ye hai 

// {3, 2, 1, 5, 6, 4} then 1st largest element is 6 

// {1, 2, 3, 4, 5, 6} then 2nd largest element is 5 
// {1, 2, 3, 4, 5, 6} then 3rd largest element is 4
//so we have to find kth largest element in the array
//and this is the output = 5


package L4AmazonMedium;

import java.util.PriorityQueue;
public class kthLargestElements {
    public static int kthLargestElement(int nums[], int k) {
        // Write your code here.

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : nums) {
            heap.add(x);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
    public static void main(String[] args) {

        int arr[] = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(kthLargestElement(arr, k));
    }
}
