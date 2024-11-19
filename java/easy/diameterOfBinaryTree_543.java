/*
    Given the root of a binary tree, return the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    The length of a path between two nodes is represented by the number of edges between them.

    Example 1:
        Input: root = [1,2,3,4,5]
        Output: 3
        Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

    Example 2:
        Input: root = [1,2]
        Output: 1

    Constraints:
        The number of nodes in the tree is in the range [1, 104].
        -100 <= Node.val <= 100
 */

public class diameterOfBinaryTree_543 {
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
    /*
        The approach for this problem is similar to other tree problems once again.
        This problem is a bit more tricky and requires a closer look in order to gain a full understanding of it.
        Since the diameter can possibly NOT pass through the root of the tree, then it is not a viable approach to
        simply add the heights of the left and the right subtrees. In order to get the correct diameter, a global variable
        must be updated as the tree is traversed and the diameter is being checked for each subtree. It is possible that there
        is a subtree that has a bigger diameter and does NOT go through the root of the tree. So, we will perform a DFS on the
        tree, and at each step we will calculate the diameter of the current subtree and update a global variable if we encounter
        a diameter larger than the current one. Our "global" variable will be stored in an int array of length 1, where the first and
        only int of the array is the diameter value. We store this in an array so we are able to pass it in as a parameter and it can
        be modified throughout runtime. The time and space complexity of this solution is O(n).
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Create result variable stored in int array
        int[] res = new int[1];
        // Call dfs on root and pass in res variable
        dfs(root, res);
        // Return result
        return res[0];
    }

    public int dfs(TreeNode root, int[] res) {
        // Base case
        if (root == null) return 0;
        // Recursive calls on the left and right subtrees
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        // Consider the current diameter and update the result variable if we are able to
        res[0] = Math.max(res[0], left+right);
        // Return the current diameter
        // We +1 to this value because we must consider the current node as well
        return 1 + Math.max(left, right);
    }
}
