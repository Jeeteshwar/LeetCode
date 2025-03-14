class Solution {
    public int maximumCandies(int[] candies, long k) {
        // Find the maximum possible candies per pile
        long left = 1;
        long right = 0;
        for (int candy : candies) {
            right = Math.max(right, candy);
        }
        
        // Binary search to find maximum candies per pile
        int result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            // Count how many piles we can make with 'mid' candies per pile
            long piles = 0;
            for (int candy : candies) {
                piles += candy / mid;
            }
            
            // If we can make at least k piles, try a larger number
            if (piles >= k) {
                result = (int)mid;
                left = mid + 1;
            } 
            // If we can't make k piles, try a smaller number
            else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}