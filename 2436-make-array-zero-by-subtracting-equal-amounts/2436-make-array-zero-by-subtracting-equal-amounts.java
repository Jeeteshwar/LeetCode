class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue <>();
        int n = nums.length;
        int count = 0;

        for(int num : nums){
            pq.offer(num);
        }
        int temp = -1;
        for(int i = 0 ; i < n ; i++){
            int x  = pq.poll();

            if(x == 0 || x == temp)
                continue;
        
        temp = x;
        count++;
        }
        return count;

    }
}