/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode head) {
        head.val = head.next.val;   // Copy the value of the next node to the current node.
        head.next = head.next.next;  // Bypass the next node by pointing the current node's next to the next node's next.
    }
}

