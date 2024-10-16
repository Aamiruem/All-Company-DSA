// package L4AmazonMedium;

// public class carPooling {
//     public static boolean carPooling(int[][] trips, int capacity) {
//         int[] stops = new int[1001];
//         for (int[] trip : trips) {
//             stops[trip[1]] += trip[0];
//             stops[trip[2]] -= trip[0];
//         }
//         for (int i = 1; i <= 1000; i++) {
//             capacity -= stops[i - 1];
//             if (capacity < 0)
//                 return false;
//         }
//         return true;
//     }
    
//     public static void main(String[] args) {
//         int[][] trips = {{2,1,5},{3,3,7}};
//         int capacity = 5;
//         System.out.println(carPooling(trips, capacity)); // Output: true
//     }
// }








package L4AmazonMedium;

public class carPooling {
    //using the constructors methods 
    private final int[][] trips;
    private int capacity;

    // Constructor to initialize the trips and capacity
    public carPooling(int[][] trips, int capacity) {
        this.trips = trips;
        this.capacity = capacity;
    }

    // Method to check if car pooling is possible
    public boolean isCarPoolingPossible() {
        int[] stops = new int[1001];
        for (int[] trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        for (int i = 0; capacity >= 0 && i <= 1000; i++) {
            capacity -= stops[i];
        }
        return capacity >= 0;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 5;

        // Create an instance of CarPooling
        carPooling carPooling = new carPooling(trips, capacity);

        // Check if car pooling is possible
        System.out.println(carPooling.isCarPoolingPossible()); // Output: true
    }
}
