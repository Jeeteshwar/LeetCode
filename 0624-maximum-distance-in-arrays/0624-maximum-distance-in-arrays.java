import java.util.*;

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // Min-Heap for smallest elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Max-Heap for largest elements
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // Fill the heaps with elements from the arrays
        for (int i = 0; i < arrays.size(); i++) {
            minHeap.offer(new int[] {arrays.get(i).get(0), i});
            maxHeap.offer(new int[] {arrays.get(i).get(arrays.get(i).size() - 1), i});
        }

        // Get the smallest and largest elements
        int[] minElement = minHeap.poll();
        int[] maxElement = maxHeap.poll();

        int minVal = minElement[0];
        int maxVal = maxElement[0];
        int diff = Math.abs(maxVal - minVal);

        // If the smallest and largest elements come from the same array
        if (minElement[1] == maxElement[1]) {
            // Get the next smallest and largest elements
            int[] nextMin = minHeap.poll();
            int[] nextMax = maxHeap.poll();
            int altDiff1 = Math.abs(nextMax[0] - minVal);
            int altDiff2 = Math.abs(maxVal - nextMin[0]);
            diff = Math.max(altDiff1, altDiff2);
        }

        return diff;
    }
}
