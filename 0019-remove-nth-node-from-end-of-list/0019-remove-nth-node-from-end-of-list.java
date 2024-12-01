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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy=new ListNode(-1);

        dummy.next= head;
        ListNode firstPtr=dummy;
        ListNode secPtr=dummy;


        for(int i = 0 ;i<n ;i++){
            secPtr=secPtr.next;

        }

        while(secPtr.next!=null){
            firstPtr = firstPtr.next;
            secPtr = secPtr.next;
        }

        firstPtr.next=firstPtr.next.next;

        return dummy.next;

    }
}