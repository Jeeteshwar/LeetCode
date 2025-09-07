class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int total = 0;
        
        // Generate first n-1 positive integers
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i + 1;
            total += ans[i];
        }
        
        // Set the last element to the negative sum
        ans[n - 1] = -total;
        return ans;
    }
}