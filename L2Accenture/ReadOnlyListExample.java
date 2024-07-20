// package All-Company-DSA.L2Accenture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyListExample {
    public static void main(String[] args) {
        // Create a list and add some elements
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Print the original list
        System.out.println("Original list: " + list);

        // Make the list read-only
        List<String> readOnlyList = Collections.unmodifiableList(list);

        // Print the read-only list
        System.out.println("Read-only list: " + readOnlyList);

        // Attempting to modify the read-only list will throw an exception
        try {
            readOnlyList.add("Date");
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception: Cannot modify a read-only list");
        }

        // The original list is still modifiable
        list.add("Date");
        System.out.println("Modified original list: " + list);
   
    }
}
