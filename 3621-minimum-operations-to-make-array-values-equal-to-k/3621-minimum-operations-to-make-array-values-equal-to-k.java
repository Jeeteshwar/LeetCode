class Solution {
    public int minOperations(int[] nums, int k) {
         Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for (int num : nums) {
            set.add(num); // Automatically handles duplicates
        }
        
        for (int num : set) {
            if(num < k ) return -1;
            else if (num > k) {
                count++;
            }
        }
        
        return count;
    }
}