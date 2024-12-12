class Solution {
    public int halveArray(int[] nums) {
        // Use a PriorityQueue to maintain a max heap
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double totalSum = 0;

        // Populate the PriorityQueue with the numbers as doubles and calculate the total sum
        for (int num : nums) {
            totalSum += num;
            pq.add((double) num);
        }

        double targetSum = totalSum / 2;
        double currSum = totalSum;
        int count = 0;

        // Continue halving the largest number until the current sum is halved
        while (currSum > targetSum) {
            double maxVal = pq.poll(); // Get the largest element
            double reducedVal = maxVal / 2; // Halve it
            currSum -= reducedVal; // Update the current sum
            pq.add(reducedVal); // Add the reduced value back to the queue
            count++; // Increment operation count
        }
        return count;
    }
}
