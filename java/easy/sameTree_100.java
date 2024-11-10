/*
    Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

    Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true

    Example 2:
        Input: p = [1,2], q = [1,null,2]
        Output: false

    Example 3:
        Input: p = [1,2,1], q = [1,1,2]
        Output: false

    Constraints:
        The number of nodes in both trees is in the range [0, 100].
        -104 <= Node.val <= 104
 */

public class sameTree_100 {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
            Similar to the max depth problem, we will use a recursive approach. We will compare the values
            at each node, and as long as they are equal we will continue traversing the tree. Our base case will
            be if both nodes are null. We use this as the base case because if we reach the end of the tree then the nodes
            will in fact be a null. Since we are comparing both trees to make sure they are the same, we have to traverse
            each one entirely. That is where the intuition comes from in regard to the base case. As soon as this condition
            fails, we know the trees are no longer the same and can exit. In the same condition of comparing the values
            we will also check to make sure that the current nodes are not null before comparing them to ensure we do not
            throw any errors. If one of them is null then we know the trees are not the same and can return false. This solution
            has a time and space complexity of O(n) because we need to traverse both trees entirely. The reason why it might not
            be (n + m) is because we are checking that both trees are the same. The program will always end its runtime without
            exceeding the size of n.
         */
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}
