/*
    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
    A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:
    Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    Output: true

Example 2:
    Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    Output: false

Constraints:
    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000].
    -104 <= root.val <= 104
    -104 <= subRoot.val <= 104
 */

public class subtreeOfAnotherTree_572 {
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
        The approach for this problem is quite similar to the sameTree problem (no. 100). Since we are checking
        for identical trees at a capacity for this problem, we will actually be using the solution to the sameTree problem and
        we will be adding onto it. We must consider a few edge cases when starting this problem. The first one being if the subroot is
        null. This would mean that the problem automatically results to true, because you can find a null in the root tree at some point.
        Another case follows right after this condition passes, and that is if the root itself is null. This would cause the problem to result
        in false because if the root is null, then we know we cannot find the subroot anywhere inside the root. The order of these 2 cases matters
        because checking if the subroot is null will allow us to avoid having to check if it is not null in the following case since we technically
        checked for this in the first edge case. After this, we can simply check if the root is the same as the subroot by calling the function.
        There is one last condition to consider, and that is the left and right subtrees of the root tree. This is because if the isSameTree method returns false,
        there will be no result being returned. So, we will recursively call isSubtree on the left and right subtrees, which will in turn also recursively call isSameTree
        on these subtrees. If either of the left or right subtrees return a true result, then we know that the subtree exists. So, we can use an || operator on the comparison
        of these subtrees and return based on the condition. This will allow us to check the whole tree and determine if the subtree exists within the root tree. This lengthy
        explanation only requires a few lines of code, and has a time complexity of O(m*n) because we must check the subtree for every node on the root tree. This is a brute force DFS approach.
        The space complexity for this solution comes out to be (m+n) because of the 2 trees.
     */

    // Method to determine if a tree is a valid subtree of another tree
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (subroot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subroot)) return true;
        return (isSubtree(root.left, subroot) ||
                isSubtree(root.right, subroot));
    }

    // Method to determine if 2 trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
