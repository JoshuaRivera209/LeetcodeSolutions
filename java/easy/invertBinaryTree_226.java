/*
    Given the root of a binary tree, invert the tree, and return its root.

    Example 1:
        Input: root = [4,2,7,1,3,6,9]
        Output: [4,7,2,9,6,3,1]

    Example 2:
        Input: root = [2,1,3]
        Output: [2,3,1]

    Example 3:
        Input: root = []
        Output: []

    Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100
 */

public class invertBinaryTree_226 {
    // TreeNode object class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // Method to invert binary tree and return result
    public TreeNode invertTree(TreeNode root) {
        /*
            The approach for this problem is similar to other easy tree problems. We will perform
            a recursive DFS on the tree, swapping the left and right children at each of the root nodes
            we encounter. We will then return the root once all the swaps have been completed. This solution
            has both a space and time complexity of O(n).
         */
        // Establish base case
        if (root == null) return root;
        // Perform swap on child nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // Recursively call on left and right subtrees to invert
        invertTree(root.left);
        invertTree(root.right);
        // Return root if it is not null
        return root;
    }
}
