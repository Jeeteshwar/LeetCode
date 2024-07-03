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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {  // making two LinkedList

        ListNode result = new ListNode(0); // setting up the result node with the staring as 0

        ListNode ptr = result; // setting ptr at the resukt LL

        int carry = 0;          //Inital value of sum == 0
 
        while(l1 != null || l2 != null){      //Running the while loop till the Both list 1 and list 2 becomes empty

            int sum = 0 + carry;            // for each iteration the value of sum and the carry
            if(l1 !=null){                 // if the list is not null

                sum += l1.val;          // sum setting up the sum of list 1 (l1[0])
                l1=l1.next;             // pointing to the next node of the list 1
            }


            if(l2 !=null){          // if the list is not null

                sum += l2.val;      // sum setting up the sum of list 2 (l1[0]+ l2[0] )
                l2=l2.next;         // pointing to the next node of the list 2
            }
             carry = sum / 10;    // Get sum and carry
             sum = sum % 10;      // This will return the once place digiti after the cut of carry

            ptr.next = new ListNode(sum); // putting the values as the result list goes on the while loop iteration
            ptr = ptr.next;

        }
        if (carry == 1) ptr.next = new ListNode(1);  // if the variable carry left with an carry of 1 it will get added at the end of the result LL

        
        return result.next;  // RETURN OF THE LIST
        
    }
}