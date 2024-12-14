class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i :nums){
            pq.offer(i);
        }
        int temp =-1;
        int res = 0;
        for(int i =0;i<nums.length;i++){
            int polled = pq.poll();
            if(polled==0 || polled==temp){
                
                continue;
            }
            temp=polled;
            res++;
        }
        return res;
    }
}