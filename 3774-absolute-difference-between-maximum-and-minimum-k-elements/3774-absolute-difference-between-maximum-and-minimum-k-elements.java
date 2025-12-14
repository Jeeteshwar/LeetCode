class Solution {
    public int absDifference(int[] nums, int k) {
        //Priotity queue
        PriorityQueue<Integer> minHeap =  new PriorityQueue <>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums){ 
            minHeap.offer(num);
            maxHeap.offer(num);
            }
        int res = 0;

        int small = 0;
        int large = 0;
        for(int i  = 0 ; i < k && !minHeap.isEmpty() ; i++){
            small += minHeap.poll();
        }

        for(int i  = 0 ; i < k && !maxHeap.isEmpty() ; i++){
            large += maxHeap.poll();
        }

        res = Math.abs(small - large);
        return res;
    }
}