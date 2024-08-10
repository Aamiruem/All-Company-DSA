
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }

// public class IntersectionOfTwoLinkedList {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         if (headA == null || headB == null) return null;

//         int lenA = getLength(headA);
//         int lenB = getLength(headB);

//         // Align the start of both lists
//         while (lenA > lenB) {
//             headA = headA.next;
//             lenA--;
//         }
//         while (lenB > lenA) {
//             headB = headB.next;
//             lenB--;
//         }

//         // Traverse both lists to find the intersection point
//         while (headA != headB) {
//             headA = headA.next;
//             headB = headB.next;
//         }

//         return headA; // or headB, since they are equal at this point
//     }

//     private int getLength(ListNode node) {
//         int length = 0;
//         while (node != null) {
//             length++;
//             node = node.next;
//         }
//         return length;
//     }

//     public static void main(String[] args) {
//         // Example to test
//         ListNode common = new ListNode(8);
//         common.next = new ListNode(10);

//         ListNode headA = new ListNode(4);
//         headA.next = new ListNode(1);
//         headA.next.next = common;

//         ListNode headB = new ListNode(5);
//         headB.next = new ListNode(6);
//         headB.next.next = new ListNode(1);
//         headB.next.next.next = common;

//         IntersectionOfTwoLinkedList ll = new IntersectionOfTwoLinkedList();
//         ListNode intersection = ll.getIntersectionNode(headA, headB);
//         if (intersection != null) {
//             System.out.println("Intersection at node with value: " + intersection.val);
//         } else {
//             System.out.println("No intersection.");
//         }
//     }
// }







public class IntersectionOfTwoLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int key) {
            val = key;
            next = null;
        }
    }

    // Function to return intersection node
    public static Node intersect(Node l1, Node l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        Node p1 = l1, p2 = l2;

        // Loop until both pointers are the same or null
        while (p1 != p2) {
            p1 = (p1 == null) ? l2 : p1.next;
            p2 = (p2 == null) ? l1 : p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        // l1 = 1->2->3->4
        // l2 = 5->3->4
        
        // Create the intersecting node
        Node intersectingNode = new Node(3);
        intersectingNode.next = new Node(4);

        // List 1: 1 -> 2 -> 3 -> 4
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = intersectingNode;

        // List 2: 5 -> 3 -> 4
        Node head2 = new Node(5);
        head2.next = intersectingNode;

        Node res = intersect(head1, head2);

        if (res != null) {
            System.out.println("Intersection at node with value: " + res.val);
        } else {
            System.out.println("No intersection.");
        }
    }
}
