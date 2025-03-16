class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long) ranks[0] * cars * cars; // Maximum possible time
        long result = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long repaired = 0;
            
            // Calculate how many cars can be repaired in 'mid' time
            for (int rank : ranks) {
                // For each mechanic: time = rank * n²
                // So n = sqrt(time/rank)
                repaired += (long) Math.sqrt(mid / rank);
            }
            
            if (repaired >= cars) {
                // If we can repair enough cars, try a lower time
                result = mid;
                right = mid - 1;
            } else {
                // If we can't repair enough cars, need more time
                left = mid + 1;
            }
        }
        
        return result;
    }
}