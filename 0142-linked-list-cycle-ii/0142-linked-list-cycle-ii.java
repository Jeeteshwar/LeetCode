/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// Definition for singly-linked list.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one element, no cycle can exist.
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists using two pointers (slow and fast).
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Slow pointer moves one step.
            fast = fast.next.next;      // Fast pointer moves two steps.

            if (fast == slow) {         // A cycle is detected if fast and slow meet.
                break;
            }
        }

        // If no cycle is detected, return null.
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the entry point of the cycle.
        while (head != slow) {
            head = head.next;          // Move head one step.
            slow = slow.next;          // Move slow one step.

            // Adding extra logic for better understanding:
            // At this point, both head and slow pointers are moving at the same pace.
            // When they meet, that will be the entry point of the cycle.
        }

        return head;  // This is the start of the cycle.
    }
}
