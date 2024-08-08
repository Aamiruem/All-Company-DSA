// public class MissingNumber {

//     public static int missingNumber(int[] nums) {
//         int n = nums.length;
//         int sum = n * (n + 1) / 2;
//         for (int i = 0; i < n; i++) {
//             sum -= nums[i];
//         }
//         return sum;
//     }
//     public static void main(String[] args) {
//         int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
//         System.out.println(missingNumber(nums));

//     }

// }








public class MissingNumber {
    
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 3;
        nums[1] = 0;
        nums[2] = 1;
        System.out.println(missingNumber(nums));
        
    }

    public static int missingNumber(int[] nums) {
        int n_xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n_xor = n_xor ^ i;
            n_xor = n_xor ^ nums[i];

        }
        return n_xor;
    }
}
