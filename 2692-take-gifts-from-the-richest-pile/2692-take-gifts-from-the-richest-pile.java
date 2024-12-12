class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for(int val : gifts){ // adding the elements from arr into the maxheap
            pq.add(val); // function call of adding
        }
        for(int i = 0 ; i < k ; i++){ // loop till the k valuie
            int x  = pq.poll(); // getting the max elements from the maxHeap everytime
            pq.add((int) Math.sqrt(x)); // adding the square value of current max into maxHeap
        }
        long sum = 0; // sum that will get return as remaining
        for(int val : pq){ 
            sum+=val; // left sum left
        }
        return sum;
    }
}