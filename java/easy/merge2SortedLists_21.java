/*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.

    Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

    Example 2:
        Input: list1 = [], list2 = []
        Output: []

    Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]

    Constraints:
        The number of nodes in both lists is in the range [0, 50].
        -100 <= Node.val <= 100
        Both list1 and list2 are sorted in non-decreasing order.
 */

public class merge2SortedLists_21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // Method to merge 2 sorted lists and return the result
    public static ListNode mergeTwoLists (ListNode list1, ListNode list2) {
        /*
            This problem will take the approach of iterating through the lists simultaneously,
            and will compare the current values at each node. We will use a dummy node at the head
            to avoid any possible edge cases we may encounter. This is common. We will then add the greater values
            to the new list. If they are equal, then we will just add the first node to the new list
            and continue comparing. If one list goes empty before the other, then we can safely add the
            remaining nodes to the new list. We will then return the newly merged list. This simple and
            straightforward approach has a time complexity of O(n+m) and a space complexity of O(n+m)
            because it is not certain that both lists will be of the same size.
         */
        // Initialize dummy node and result (tail) list
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        // We return dummy.next here to avoid returning the null node at the head
        return dummy.next;
    }
}
