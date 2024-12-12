class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int val : nums){
            pq.add((long)val);
        }

        int count = 0;
        while(pq.peek() < k && pq.size() > 1){
            long x = pq.poll();
            long y = pq.poll();

            long newNum = x * 2 + y;
            pq.add(newNum);
            count++;
        }
        return count;
    }
}