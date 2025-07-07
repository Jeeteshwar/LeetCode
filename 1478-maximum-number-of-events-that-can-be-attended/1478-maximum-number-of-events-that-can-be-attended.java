import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, attended = 0;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0]; // jump to next available event's start
            }

            // Add all events starting today
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove all events that have already ended
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll(); // Attend the event with earliest end day
                attended++;
            }

            day++; // move to next day
        }

        return attended;
    }
}
