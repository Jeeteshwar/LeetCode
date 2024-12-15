class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Priority queue to act as a max-heap, storing {delta, index} pairs
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Populate the priority queue with initial delta values and indices
        for (int i = 0; i < n; i++) {
            int pass = classes[i][0];
            int total = classes[i][1];
            double currentRatio = (double) pass / total;
            double newRatio = (double) (pass + 1) / (total + 1);
            double delta = newRatio - currentRatio;
            maxHeap.offer(new double[]{delta, i});
        }

        // Distribute extra students to maximize the average pass ratio
        while (extraStudents > 0) {
            double[] top = maxHeap.poll(); // Extract the class with the highest delta
            int index = (int) top[1];

            // Add one student to the selected class
            classes[index][0]++;
            classes[index][1]++;

            // Recalculate the delta for this class and reinsert into the heap
            int pass = classes[index][0];
            int total = classes[index][1];
            double currentRatio = (double) pass / total;
            double newRatio = (double) (pass + 1) / (total + 1);
            double delta = newRatio - currentRatio;
            maxHeap.offer(new double[]{delta, index});

            extraStudents--;
        }

        // Calculate the final average pass ratio
        double totalAverage = 0.0;
        for (int i = 0; i < n; i++) {
            totalAverage += (double) classes[i][0] / classes[i][1];
        }

        return totalAverage / n;
    }
}
