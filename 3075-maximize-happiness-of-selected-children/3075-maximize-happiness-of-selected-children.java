class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;

        long result=0;
        int count=0;

        // Start the loop from n - 1 instead of n

        for(int i = n-1 ; i >= n-k ; i--){     

            result+= Math.max(happiness[i]-count,0);

            count++;

        }

        return result;
    }
}