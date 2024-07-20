
import java.util.*;

public class IndexOfSubArraySum {

    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentSum = 0;
        int start = 1;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum > s && start <= end) {
                currentSum -= arr[start - 1];
                start++;
            }

            if (currentSum == s) {
                result.add(start);
                result.add(end + 1);
                return result;
            }
        }

        result.add(-1);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.close();
        }
        System.out.print("Enter the target sum: ");
        int s = sc.nextInt();
        ArrayList<Integer> result = subarraySum(arr, n, s);
        if (result.get(0) == -1) {
            System.out.println("No subarray found with sum " + s);
        } else {
            System.out.println("Subarray found with sum " + s + " from index " + result.get(0) + " to " + result.get(1));
        }
    }
}
