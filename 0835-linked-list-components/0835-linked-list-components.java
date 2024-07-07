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
    public int numComponents(ListNode head, int[] nums) {
         // If the linked list is empty, return 1 as there are no components.
        if(head == null) return 1;

        // Initialize count of components to 0.
        int n = 0;

        // A boolean flag to indicate if we are currently in a component.
        boolean inComponent  = false;

         // Create a set to store the values in nums for quick lookup.
        HashSet <Integer> set = new HashSet <>();

        // Add all values from Array nums into the set.
        for(int i : nums){
            set.add(i);
        }

        // Traverse the linked list.
        while(head != null){
            // Check if the current node's value is in the set.
            if(set.contains(head.val)){
            // If we are not already in a component, increment the count and set the flag to true.
                if(inComponent == false){
                    n++;
                    inComponent = true;
                }
            }
            // If the current node's value is not in the set, set the flag to false.
            else{
                inComponent  = false;
            }
            // Move to the next node in the linked list.
            head = head.next;
        }
        // Return the total number of components.
        return n;
    }
}