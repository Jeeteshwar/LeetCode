class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Create a HashMap to store the frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate over the array and update the frequency of each element in the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Initialize variables to track the maximum frequency and the count of elements
        int count = 0;
        int maxFreq = Integer.MIN_VALUE;

        // Find the maximum frequency among all elements in the map
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Count the total occurrences of elements with the maximum frequency
        for (int num : map.values()) {
            if (num == maxFreq) {
                count += maxFreq; // Add the frequency of the current element to the count
            }
        }

        // Return the total count of elements with the maximum frequency
        return count;
    }
}
