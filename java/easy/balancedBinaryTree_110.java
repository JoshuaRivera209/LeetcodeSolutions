public class balancedBinaryTree_110 {
    // Tree Node object class
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
        The approach for this problem is very similar to the diameter tree problem (no. 543). This problem utilizes
        the heights of the trees slightly different from the diameter problem to achieve a different goal. The idea is still the same.
        Perform a dfs on every left and right subtree. Instead of modifying a global int that will hold the maximum diameter from the tree,
        the array will hold a single boolean that will start as true. The boolean will only be switched to false under the condition that
        the tree is not balanced. This is the value that will be returned. The ultimate goal is to traverse the tree without this condition
        becoming true, so the true is the result returned when the tree is balanced. Otherwise false is returned if the tree is found to be
        unbalanced at any time. Since the whole tree must be traversed, this solution becomes O(n) for both space and time complexity similar
        to the diameter and some other tree problems. The reason these complexities are more common with trees is because recursion tends to
        take up more memory due to the constant function calls despite it being efficient to run.
     */

    // Method to return if the tree is balanced or not
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        dfs(root, res);
        return res[0];
    }

    // Method to perform dfs and determine whether or not the tree is balanced
    public int dfs(TreeNode root, boolean[] res) {
        // Base case
        if (root == null) return 0;
        // Recursive calls on the left and right subtrees
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        if (Math.abs(right - left) > 1) {
            res[0] = false;
        }
        // We +1 here to consider the current node alongside the heights of the left/right
        return 1 + Math.max(left, right);
    }
}
