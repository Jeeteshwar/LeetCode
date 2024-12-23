class Solution {
    public int distinctAverages(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        PriorityQueue<Double> qp = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        HashSet<Double> seen = new HashSet<>();

        for(double num : nums){
            pq.add(num);
            qp.add(num);

        }
        double avg = 0;
        while(n > 0){
            avg = (pq.poll() + qp.poll()) / 2;
            seen.add(avg);
            n -=2;
        }
        return seen.size();
    }
}