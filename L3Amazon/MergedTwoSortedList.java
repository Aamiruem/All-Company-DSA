

import java.util.ArrayList;
import java.util.List;

public class MergedTwoSortedList {
    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both lists and insert the smaller element from either list into mergedList
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements of list1, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Add remaining elements of list2, if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Example input
        list1.add(1);
        list1.add(3);
        list1.add(5);
        
        list2.add(2);
        list2.add(4);
        list2.add(6);

        List<Integer> mergedList = mergeSortedLists(list1, list2);
        System.out.println("Merged List: " + mergedList);
    }
}
