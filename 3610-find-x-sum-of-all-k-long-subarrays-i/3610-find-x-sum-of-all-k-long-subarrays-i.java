import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] freq = new int[51];
        
        // Initialize first window
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }
        
        for (int i = 0; i <= n - k; i++) {
            result[i] = calculateXSumWithPQ(freq, x);
            
            if (i < n - k) {
                freq[nums[i]]--;
                freq[nums[i + k]]++;
            }
        }
        
        return result;
    }
    
    private int calculateXSumWithPQ(int[] freq, int x) {
        // Max heap: compare by frequency, then by value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1]; // higher frequency first
            return b[0] - a[0]; // higher value first for same frequency
        });
        
        for (int value = 1; value <= 50; value++) {
            if (freq[value] > 0) {
                pq.offer(new int[]{value, freq[value]});
            }
        }
        
        int sum = 0;
        int count = Math.min(x, pq.size());
        
        for (int i = 0; i < count; i++) {
            int[] element = pq.poll();
            sum += element[0] * element[1];
        }
        
        return sum;
    }
}