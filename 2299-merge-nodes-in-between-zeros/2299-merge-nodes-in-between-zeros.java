/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
      // Initialize p1 to the first node after the head
        ListNode p1 = head.next;
        // Initialize p2 to the same node as p1
        ListNode p2 = p1;

        // Traverse the list with p2
        while (p2 != null) {
            int sum = 0;

            // Sum up the values between zeros
            while (p2 != null && p2.val != 0) {
                sum += p2.val;
                p2 = p2.next;
            }
            // Assign the calculated sum to the current node pointed by p1
            p1.val = sum;
            // Move p2 to the next node (skipping the zero)
            p2 = p2.next;
            // Link the current p1 node to the next zero-node pointed by p2
            p1.next = p2;
            // Move p1 to the next node for the next sum calculation
            p1 = p1.next;
        }
        // Return the modified list, skipping the initial head
        return head.next;
    }
}