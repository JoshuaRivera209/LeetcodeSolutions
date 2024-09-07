/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */

public class reverseLinkedList_206 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Method to reverse linked list and return result
    public static ListNode reverseList (ListNode head) {
        // Check if head exists first, if it doesn't then we don't
        // need to do anything and can exit.
        if (head == null) {
            return null;
        }

        // Store the current and previous nodes
        ListNode curr = head;
        ListNode prev = null;

        // While the current node exists, we will traverse the linked list
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Once we exit our while loop and the linked list has been reversed,
        // return prev as this is where the reversed list will be stored.
        return prev;
    }
}
