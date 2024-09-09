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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Step 1: Initialize a 2D array (matrix) of size m x n with all elements set to -1
        int[][] matrix = new int[m][n];
        
        // Initialize the matrix with -1 to indicate empty spaces
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        // Step 2: Define the boundaries for the spiral traversal
        int top = 0;     // Initial top boundary
        int down = m - 1; // Initial bottom boundary
        int left = 0;    // Initial left boundary
        int right = n - 1; // Initial right boundary

        // id is used to track the direction of traversal: 
        // 0 = left to right, 1 = top to bottom, 2 = right to left, 3 = bottom to top
        int id = 0;

        // Step 3: Traverse the matrix in a spiral order and fill it with values from the linked list
        while (top <= down && left <= right && head != null) {
            if (id == 0) { // Traverse from left to right
                for (int i = left; i <= right && head != null; i++) {
                    matrix[top][i] = head.val; // Fill the current position with the node's value
                    head = head.next; // Move to the next node in the list
                }
                top++; // Move the top boundary downwards
            } 
            else if (id == 1) { // Traverse from top to bottom
                for (int i = top; i <= down && head != null; i++) {
                    matrix[i][right] = head.val;
                    head = head.next;
                }
                right--; // Move the right boundary leftwards
            } 
            else if (id == 2) { // Traverse from right to left
                for (int i = right; i >= left && head != null; i--) {
                    matrix[down][i] = head.val;
                    head = head.next;
                }
                down--; // Move the bottom boundary upwards
            } 
            else if (id == 3) { // Traverse from bottom to top
                for (int i = down; i >= top && head != null; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++; // Move the left boundary rightwards
            }

            // Step 4: Update the direction to the next one in the cycle
            id = (id + 1) % 4;
        }

        // Step 5: Return the filled matrix
        return matrix;
    }
}
