package L4AmazonMedium;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { 
        val = x; 
    }
}

public class BinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        // Base case
        if (root == null) {
            return;
        }
        
        // Flatten the left and right subtree recursively
        flatten(root.left);
        flatten(root.right);
        
        // Store the right subtree
        TreeNode tempRight = root.right;
        
        // Move the left subtree to the right
        root.right = root.left;
        root.left = null; // Make sure the left subtree is set to null
        
        // Traverse to the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // Attach the previously stored right subtree
        current.right = tempRight;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        
        BinaryTreeToLinkedList bt = new BinaryTreeToLinkedList();
        bt.flatten(root);
        
        // Output the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
    }    
}
