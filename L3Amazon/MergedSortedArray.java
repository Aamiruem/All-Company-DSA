import java.util.Arrays;

public class MergedSortedArray {

    public static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        // Calculate actual lengths of the arrays
        int i = m - 1;
        int j = n - 1;
        int x = m + n - 1;

        // Merge nums2 into nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[x] = nums1[i];
                i--;
            } else {
                nums1[x] = nums2[j];
                j--;
            }
            x--;
        }

        // Copy any remaining elements from nums2 into nums1
        while (j >= 0) {
            nums1[x] = nums2[j];
            j--;
            x--;
        }
        
        return nums1;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        
        int[] nums1 = new int[m + n];
        int[] nums2 = new int[n];
        
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;
        
        System.out.println("Merged array: " + Arrays.toString(mergeSortedArray(nums1, m, nums2, n)));
        
        System.out.println("Elements of the merged array:");
        for (int i = 0; i < m + n; i++) {
            System.out.println(nums1[i]);
        }
        
        System.out.println("done");
    }
}
// Output: Merged array: [1, 2, 2, 3, 5, 6]
