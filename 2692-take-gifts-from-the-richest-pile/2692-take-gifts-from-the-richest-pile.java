class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int val : gifts){
            pq.add(val);

        }

        for(int i = 0 ; i < k ; i++){
            int x  = pq.poll();

            pq.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for(int val : pq){
            sum+=val;
        }
        return sum;
    }
}