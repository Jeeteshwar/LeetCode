class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        HashMap<Integer, Integer> mp = new HashMap<>(); // HashMap to store the element and its latest index

        for (int i = 0; i < n; i++) {
            // Check if the current element exists in the HashMap
            if (mp.containsKey(nums[i])) {
                // Calculate the difference between the current index and the last index of this element
                int diff = i - mp.get(nums[i]);
                
                // If the difference is less than or equal to k, we found a nearby duplicate
                if (diff <= k) {
                    return true;
                }
            }
            // Update the HashMap with the current index of the element
            mp.put(nums[i], i);
        }
        // If no nearby duplicates are found, return false
        return false;
    }
}
