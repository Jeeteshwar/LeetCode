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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a set to store the values that need to be removed
        Set<Integer> toBeDel = new HashSet<>();

        // Add each number in nums to the set
        for (int num : nums) toBeDel.add(num);

        // Create a dummy head to simplify edge cases, like removing the actual head of the list
        ListNode dummyHead = new ListNode();

        // Point the dummy head's next to the original head of the list
        dummyHead.next = head;

        // Initialize two pointers: curr to traverse the list, and prev to keep track of the previous node
        ListNode curr = dummyHead, prev = dummyHead;

        // Traverse the list
        while (curr != null) {
            // Store the next node
            ListNode nextNode = curr.next;

            // If the current node's value is in the set, bypass the current node
            if (toBeDel.contains(curr.val)) {
                prev.next = nextNode;
            } else {
                // Otherwise, move the prev pointer to the current node
                prev = curr;
            }

            // Move to the next node
            curr = nextNode;
        }

        // Return the modified list, starting from the original head or the first node after dummyHead
        return dummyHead.next;
    }
}