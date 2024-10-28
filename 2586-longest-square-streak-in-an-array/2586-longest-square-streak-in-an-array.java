class Solution {
    public int longestSquareStreak(int[] nums) {
        // Create a HashMap to store the number and its associated streak length
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Sort the array so that we can process numbers in ascending order
        Arrays.sort(nums);

        // Variable to store the maximum streak length
        int maxstreak = 0;

        // Loop through each number in the sorted array
        for (int num : nums) {
            // Find the square root of the current number
            int root = (int) Math.sqrt(num);

            // Check if the current number is a perfect square and if its square root
            // has already been encountered in the HashMap
            if (root * root == num && mp.containsKey(root)) {
                // If both conditions are met, update the streak for this number
                mp.put(num, mp.get(root) + 1);
            } else {
                // If the number is not a perfect square or its square root hasn't been processed,
                // initialize its streak length as 1
                mp.put(num, 1);
            }

            // Update the maximum streak length encountered so far
            maxstreak = Math.max(maxstreak, mp.get(num));
        }

        // If the maximum streak is less than 2, return -1, otherwise return the max streak
        return maxstreak < 2 ? -1 : maxstreak;
    }
}
