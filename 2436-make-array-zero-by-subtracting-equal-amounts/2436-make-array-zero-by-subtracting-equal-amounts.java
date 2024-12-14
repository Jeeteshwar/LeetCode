class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue <>(); //min heap
        int n = nums.length;
        int count = 0;

        for(int num : nums){ 
            pq.offer(num); // adding into heap
        }
        int temp = -1; // to check duplicate occurance
        for(int i = 0 ; i < n ; i++){
            int x  = pq.poll(); // adding smallest element into the x

            if(x == 0 || x == temp) // if true then move to next i element ( basically checking if curr element is 0 or like previous value(duplicate))
                continue;
        
        temp = x; // to keep the current passed element(basically checks for duplicate)
        count++; // increment the result
        }
        return count;

    }
}