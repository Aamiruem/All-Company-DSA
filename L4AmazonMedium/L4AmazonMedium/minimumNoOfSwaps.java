package L4AmazonMedium;

public class minimumNoOfSwaps {
    public static int minSwaps(String s) {
        int count0 = 0, count1 = 0, miss0 = 0, miss1 = 0;

        // Count the number of '0's and '1's
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        // If the difference between count of '0's and '1's is greater than 1, return -1
        if (Math.abs(count0 - count1) > 1) {
            return -1;
        }

        // Calculate the number of misplaced '0's and '1's
        for (int i = 0; i < s.length(); i += 2) {
            if (i < s.length() && s.charAt(i) != '0') {
                miss0++;
            }
            if (i + 1 < s.length() && s.charAt(i + 1) != '1') {
                miss1++;
            }
        }

        // Return the minimum number of swaps needed
        return count0 == count1 ? Math.min(miss0, miss1) : (count0 > count1 ? miss0 : miss1);
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("111000"));  // Output: 1
        System.out.println(minSwaps("00100"));   // Output: 0
        System.out.println(minSwaps("111111"));  // Output: -1
    }
}
