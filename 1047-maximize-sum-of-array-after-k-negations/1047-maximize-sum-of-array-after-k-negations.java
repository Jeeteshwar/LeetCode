class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue <>();

        for(int num : nums){
            pq.add(num);
        }
        while(k > 0){
            int x = -pq.poll();
            pq.add(x);
            k--;
        }

        int sum = 0;

        for(int i = 0 ; i < nums.length ; i++){
            sum+= pq.poll();
        }
        return sum;
    }
}