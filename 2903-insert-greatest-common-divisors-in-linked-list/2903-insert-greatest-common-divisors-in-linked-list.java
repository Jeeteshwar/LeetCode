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
    
    // Helper function to calculate the greatest common divisor (GCD) of two integers
    private int gcd(int a, int b) {
        // Base case: if the second number becomes 0, return the first number
        if(b == 0) {
            return a;
        }
        // Recursive step: compute gcd by calling the function with (b, a % b)
        return gcd(b, a % b);
    }
    
    // Main function to insert GCD values between consecutive nodes in the linked list
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Edge case: if the list is empty or has only one node, return it as is
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize two pointers to traverse the list: 'curr' for the current node and 'next' for the next node
        ListNode currNode = head;
        ListNode nextNode = head.next;

        // Traverse through the linked list as long as 'next' is not null
        while (nextNode != null) {
            // Calculate the GCD of the current node's value and the next node's value
            ListNode temp = new ListNode(gcd(currNode.val, nextNode.val));

            // Insert the new node with GCD value between 'curr' and 'next'
            currNode.next = temp;
            temp.next = nextNode;

            // Move the 'curr' pointer to 'next', and advance 'next' to the next node in the list
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        
        // Return the modified list with GCD nodes inserted between the original nodes
        return head;
    }
}
