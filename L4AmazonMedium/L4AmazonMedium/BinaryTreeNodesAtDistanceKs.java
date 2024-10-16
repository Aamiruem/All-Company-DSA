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

public class BinaryTreeNodesAtDistanceKs {
    // Function to find nodes at distance k from a given node
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (k < 0)
            return result; // Invalid distance

        // Find the target node and perform DFS
        findNodesAtDistanceK(root, target, k, result);

        return result;
    }

    // Helper function to perform DFS and find nodes at distance k
    private int findNodesAtDistanceK(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null)
            return -1;

        if (node == target) {
            // If this is the target node, start finding nodes at distance k
            findNodesAtDistanceKHelper(node, k, result);
            return 0;
        }

        int leftDistance = findNodesAtDistanceK(node.left, target, k, result);
        if (leftDistance != -1) {
            // If target is found in left subtree, find nodes at remaining distance in right
            // subtree
            if (leftDistance + 1 == k) {
                result.add(node.val);
            } else {
                findNodesAtDistanceKHelper(node.right, k - leftDistance - 1, result);
            }
            return leftDistance + 1;
        }

        int rightDistance = findNodesAtDistanceK(node.right, target, k, result);
        if (rightDistance != -1) {
            // If target is found in right subtree, find nodes at remaining distance in left
            // subtree
            if (rightDistance + 1 == k) {
                result.add(node.val);
            } else {
                findNodesAtDistanceKHelper(node.left, k - rightDistance - 1, result);
            }
            return rightDistance + 1;
        }

        return -1; // Target not found in this subtree
    }

    // Helper function to find nodes at distance k from a given node
    private void findNodesAtDistanceKHelper(TreeNode node, int k, List<Integer> result) {
        if (node == null || k < 0)
            return;

        if (k == 0) {
            result.add(node.val);
            return;
        }

        findNodesAtDistanceKHelper(node.left, k - 1, result);
        findNodesAtDistanceKHelper(node.right, k - 1, result);
    }

    public static void main(String[] args) {
        BinaryTreeNodesAtDistanceK solution = new BinaryTreeNodesAtDistanceK();

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
