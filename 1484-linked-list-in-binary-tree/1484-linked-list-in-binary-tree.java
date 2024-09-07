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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean check(ListNode head , TreeNode root){

        if(head == null) return true; // if all the nodes has been visisted

        if(root == null) return false; // if root is null that means can't traverse the tree

        if(head.val != root.val) // if the root val is not equal to the head val 
                                // no point of traversing the sub tree
            return false;
        
         return check(head.next , root.left) || check(head.next , root.right); // else goto sub trees
                                                                    // try to find the nodes in the subtree
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) // if root is null that means can't traverse the tree
            return false;
        
        return check(head , root) || isSubPath(head, root.left) || isSubPath(head , root.right);
        // calling the check function and isSubPath function recurcively
    }   


}