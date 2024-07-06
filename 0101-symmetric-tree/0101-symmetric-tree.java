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
    public boolean check(TreeNode p,TreeNode q){
        if(p == null && q == null){ // if both trees are null return true
            return true;
        }
        if(p == null || q == null){ //if any of them are null return false;
            return false;
        }

        if(p.val == q.val){ // enter the subtress only if the root val of both tree are the same
            return check(p.left, q.right) && check(p.right,q.left); // running the recursion call (first: normal p.left and q.right) (second: like a  
        }                                                                           //mirror to the tree p.right subtree then q.left subtree eg: mirror changes the 
                                                                                    //prespective)
              //if above both conditions were satisfied then it would have returned true else it will  return    
             //false      
            return false;                    
    }
    public boolean isSymmetric(TreeNode root) {
       //in the local
        if(root == null){  //checking if the root is null
            return true;   //returning true
        }
        return check(root.left,root.right); //magic of recursion
    }
}