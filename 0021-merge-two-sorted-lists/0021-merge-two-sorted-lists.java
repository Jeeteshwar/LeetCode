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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){ // initial of two lists name l1 and l2 

        ListNode returnNode = new ListNode(Integer.MIN_VALUE); // new list initilization

        ListNode HeadNode= returnNode; 

        while( l1!= null && l2!= null){ // setting the loop thill it reaches the null

            if  ( l1.val <= l2.val){ //comparision between l1[i] and l2[i]
                returnNode.next = l1; // moving the pointer
                l1= l1.next;
            }
            else{
                returnNode.next = l2; // if the l1[i] <  l2[i] 
                l2 = l2.next; // moving the pointer
            }
            returnNode= returnNode.next; // returning the node

        }

        if (l1 == null){ // if nothing left in the list 1
            returnNode.next=l2;
        }
        else if (l2 == null){   //if nothing left in the list 2
            returnNode.next=l1;

        }   

        return HeadNode.next; // returning the main code
        }





    }
