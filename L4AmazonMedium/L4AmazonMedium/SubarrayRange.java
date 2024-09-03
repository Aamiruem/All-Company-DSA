package L4AmazonMedium;

public class SubarrayRange {
    public static long subarrayRanges(int nums[]) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int minVal = nums[i];
            int maxVal = nums[i];
            for (int j = i + 1; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ans += maxVal - minVal;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = { 1, 3, 3 };
        System.out.println("Sum of ranges = " + subarrayRanges(nums));
    }
}
