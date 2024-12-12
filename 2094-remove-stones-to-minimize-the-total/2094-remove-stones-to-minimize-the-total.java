class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int val : piles){
            pq.add(val);
        }
        for(int i = 0 ; i < k ; i++){
            int x = pq.poll();
            x -= x / 2;
            pq.add(x);

        }
        int sum = 0;
    
        for(int num : pq){
            sum+= num;
        }

        return sum;

    }
}