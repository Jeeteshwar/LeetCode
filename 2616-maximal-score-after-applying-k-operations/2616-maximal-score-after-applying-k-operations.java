class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){
            pq.add(num);
        }
        for (int i = 0; i < k; i++) {
        int maxele = pq.poll();  // Remove and get the largest element
        sum += maxele;           // Add it to the cumulative sum

            // Reduce the largest element by dividing it by 3, rounding up
        maxele = (int) Math.ceil(maxele / 3.0);
        pq.add(maxele);  // Add the reduced value back into the heap
        }

        return sum;
    }
    
}