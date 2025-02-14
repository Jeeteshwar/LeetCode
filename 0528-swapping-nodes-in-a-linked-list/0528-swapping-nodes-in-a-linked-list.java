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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;

        for(int i = 1 ; i < k ;i++){ //
            curr = curr.next; // taking curr at kth node
        }
        ListNode a = curr; // a at starting kth node
        ListNode b = head; // b at head (to be find the ending kth node)

        while(curr != null && curr.next != null){ // till curr != null
            curr = curr.next; // curr at last node
            b = b.next; // b at kth at end
        }
        // basic swap
        int temp = a.val;
        a.val = b.val;
        b.val = temp;

        return head;
    }
}