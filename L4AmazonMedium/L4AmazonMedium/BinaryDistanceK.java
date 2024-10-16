package L4AmazonMedium;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryDistanceK {
    // Function to find nodes at distance k from a given node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null || k < 0)
            return result; // Edge cases for invalid input

        // Find the target node and perform DFS to gather nodes at distance k
        findNodesAtDistanceK(root, target, k, result);

        return result;
    }

    // Recursive function to perform DFS and find nodes at distance k
    private int findNodesAtDistanceK(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null)
            return -1;

        if (node == target) {
            // If the target node is found, find all nodes at distance k from here
            findNodesAtDistanceKHelper(node, k, result);
            return 0; // Distance from target node to itself is 0
        }

        // Check the left subtree for the target node
        int leftDistance = findNodesAtDistanceK(node.left, target, k, result);
        if (leftDistance != -1) {
            // If the target is in the left subtree
            if (leftDistance + 1 == k) {
                result.add(node.val); // Add current node if it's at the correct distance
            } else {
                // Find nodes at remaining distance in the right subtree
                findNodesAtDistanceKHelper(node.right, k - leftDistance - 1, result);
            }
            return leftDistance + 1; // Return the distance of this node from the target
        }

        // Check the right subtree for the target node
        int rightDistance = findNodesAtDistanceK(node.right, target, k, result);
        if (rightDistance != -1) {
            // If the target is in the right subtree
            if (rightDistance + 1 == k) {
                result.add(node.val); // Add current node if it's at the correct distance
            } else {
                // Find nodes at remaining distance in the left subtree
                findNodesAtDistanceKHelper(node.left, k - rightDistance - 1, result);
            }
            return rightDistance + 1; // Return the distance of this node from the target
        }

        return -1; // Target not found in this subtree
    }

    // Helper function to find nodes at exact distance k from a given node
    private void findNodesAtDistanceKHelper(TreeNode node, int k, List<Integer> result) {
        if (node == null || k < 0)
            return;

        if (k == 0) {
            result.add(node.val); // Node at distance k is found
            return;
        }

        // Explore both left and right subtrees with reduced distance
        findNodesAtDistanceKHelper(node.left, k - 1, result);
        findNodesAtDistanceKHelper(node.right, k - 1, result);
    }

    public static void main(String[] args) {
        BinaryTreeNodesAtDistanceKs solution = new BinaryTreeNodesAtDistanceKs();

        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(8);

        // Find nodes at distance k from a given target node
        List<Integer> result = solution.distanceK(root, root.left, 2);

        System.out.println("Nodes at distance k: " + result);
    }
}
