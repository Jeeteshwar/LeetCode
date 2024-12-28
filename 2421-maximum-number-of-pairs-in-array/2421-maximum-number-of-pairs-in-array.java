class Solution {
    public int[] numberOfPairs(int[] nums) {
        // Frequency map to store count of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each number in nums
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Variables to store the number of pairs and leftover elements
        int pairs = 0;
        int leftovers = 0;

        // Iterate over the map to calculate pairs and leftovers
        for (int count : map.values()) {
            pairs += count / 2;           // Add pairs
            leftovers += count % 2;       // Add leftovers
        }

        // Return the result as an array
        return new int[] { pairs, leftovers };
    }
}
