package L4AmazonMedium;

import java.util.TreeMap;
public class MeetingRooms2 {

    public static int minMeetings(int arr[][]) {
        TreeMap<Integer, Integer> temp = new TreeMap<>();
        int ans = 0, count = 0;
        for (int []i : arr) {
            int start = i[0], end = i[1];
            temp.put(start, temp.getOrDefault(start, 0) + 1);
            temp.put(end, temp.getOrDefault(end, 0) - 1);
        }

        for (int k : temp.keySet()) {
            count += temp.get(k);
            ans = Math.max(ans, count);
        }

        return ans;

    }

    public static void main(String[] args) {

        // int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int arr[][] = new int[3][2];
        arr[0][0] = 0;
        arr[0][1] = 30;
        arr[1][0] = 5;
        arr[1][1] = 10;
        arr[2][0] = 15;
        arr[2][1] = 20;

        System.out.println(minMeetings(arr));
    }
}
