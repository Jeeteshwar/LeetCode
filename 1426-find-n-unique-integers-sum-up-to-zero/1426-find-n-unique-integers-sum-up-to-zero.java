class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int total = 0;
        int [] edge = new int[2];
        edge[0] = 1;
        edge[1] = -1;
        // Generate first n-1 positive integers
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i;
            total += ans[i];
        }
        
        // Set the last element to the negative sum
        ans[n - 1] = -total;
        if(n == 2){
            return edge;
        }
        return ans;
    }
}