class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length; // Get the length of the array
        int sum = 0; // Variable to hold the total sum of the array modulo p

        // First, calculate the total sum of the array, then take its modulo p
        for(int num : nums){
            sum = (sum + num) % p; // Adding each element and taking mod p at every step
        }

        // 'target' is the remainder we need to remove to make the sum divisible by p
        int target = sum % p;

        // If the total sum is already divisible by p, no need to remove any subarray
        if(target == 0){
            return 0; // Return 0 because no subarray needs to be removed
        }

        // HashMap to store the remainders (mod p) and their corresponding indices
        // mp.put(0, -1) initializes with 0 remainder at the "index" before the array starts
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int curr = 0; // 'curr' holds the current prefix sum (mod p) as we go through the array
        int result = n; // 'result' will store the minimum subarray length to be removed, start with max value n

        // Traverse through the array
        for(int j = 0; j < n; j++){
            // Add the current element to the prefix sum and take modulo p
            curr = (curr + nums[j]) % p;

            // 'remain' is the value we need to find in the hashmap to achieve divisibility by p
            // It is the difference between the current prefix sum and the target, adjusted by mod p
            int remain = (curr - target + p) % p;

            // If this 'remain' exists in the hashmap, it means there is a subarray we can remove
            if(mp.containsKey(remain)){
                // Update 'result' with the minimum subarray length that can be removed
                result = Math.min(result, j - mp.get(remain));
            }

            // Store the current prefix sum (mod p) and its index in the hashmap
            mp.put(curr, j);
        }

        // If we found a valid subarray, return its length; otherwise, return -1 (no valid subarray)
        return result == n ? -1 : result;
    }
}
