import java.util.*;

class Solution {
    public double minimumAverage(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> qp = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        double[] res = new double[n];
        int i = 0; // To track index for res array

        for (int num : nums) {
            pq.add(num);
            qp.add(num);
        }

        while (n > 0) {
            double avg = (pq.poll() + qp.poll()) / 2.0; // Corrected precedence
            res[i++] = avg; // Add to result array
            n--; // Reduce n to avoid infinite loop
        }

        // Find minimum value in res
        double minAvg = res[0];
        for (double val : res) {
            if (val < minAvg) {
                minAvg = val;
            }
        }

        return minAvg; // Return the smallest average
    }
}
