/*
    Given the root of a binary tree, return its maximum depth.
    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: 3

    Example 2:
        Input: root = [1,null,2]
        Output: 2

    Constraints:
        The number of nodes in the tree is in the range [0, 104].
        -100 <= Node.val <= 100
 */

public class maxDepthBinaryTree_104 {
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
    // Method to find and return max depth of tree
    public int maxDepth(TreeNode root) {
        /*
            This problem will use a very simple and elegant solution, with some understanding in order
            to come to this conclusion. We will perform a recursive DFS that will return the max
            depth of tree. Our base case will be if the current node is null of course. If it is not,
            we will recursively call our function on the left and right subtrees, comparing their values and
            returning the depth that they arrive at. The reason this works is because each time we call the function
            we are adding 1 to the output. This will increment the depth every time we call the function, ensuring we
            get the max. We compare between the left and right subtree of the root to see which DFS yielded a larger number.
            The reason there is no miscount here is due to the fact that we return 0 whenever the current node is null, AKA
            we reach our base case. This solution comes out to be O(n) for both time complexity and space complexity. Do note
            that recursion typically uses a lot more memory because we utilize function calls which will fill the call stack
            quickly if we have a very large input size. Despite its speed, this is a drawback because this limits our input
            size to the size of the call stack which is 1-2MB for Java Virtual Machines (JVMs).
         */
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
