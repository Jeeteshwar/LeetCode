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

    int lengthLL(ListNode head){
        int length = 0;

        while(head!=null){
            length++;
            head=head.next;

        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int l = lengthLL(head);

        if(l==n){
            ListNode temp = head.next;
            return head.next;
        
        }

        int travel_from_front = l-n;

        ListNode temp = head;
        ListNode prev = null;

        while(travel_from_front != 0){

            prev=temp;
            temp=temp.next;
            travel_from_front--;

        }

        prev.next = temp.next;
        return head;


    }
}