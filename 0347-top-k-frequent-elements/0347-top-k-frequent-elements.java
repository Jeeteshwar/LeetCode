class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b)); // sorting the pq with less frequent at top
                                                                                            // if want most frequent at top 
                                                                                            // ((a,b) -> map.get(b) - map.get(a))

        for(int num : map.keySet()){
            pq.add(num);
            if(pq.size () > k){
                pq.poll();
            } 
            }
        int [] res = new int [k];
        for(int i = 0 ; i < k ; i++){
            res[i] = pq.poll();
        }
        return res;

    }
}