import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of numbers
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // PriorityQueue to sort even numbers by frequency (descending) and value (ascending)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a - b; // If frequencies are equal, sort by smallest value
            }
            return map.get(b) - map.get(a); // Sort by frequency (descending)
        });

        // Add only even numbers to the PriorityQueue
        for (int num : map.keySet()) {
            if (num % 2 == 0) {
                pq.add(num);
            }
        }

        // Return the top element (most frequent even number) or -1 if no even number exists
        return pq.isEmpty() ? -1 : pq.peek();
    }
}
