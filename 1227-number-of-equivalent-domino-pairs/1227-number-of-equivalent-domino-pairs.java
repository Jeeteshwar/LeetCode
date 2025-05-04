import java.util.HashMap;

class Solution {
    public int numEquivDominoPairs(int[][] dom) {
        // Create a hash map to store the frequency of each domino
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int[] d : dom) {
            int a = d[0], b = d[1];
            // Normalize the domino by ensuring a <= b
            if (a > b) {
                // Swap a and b using XOR swap (a clever way to swap without a temporary variable)
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            // Create a key for the normalized domino
            String key = a + "," + b;
            // Update the frequency count in the map
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int res = 0;
        // Calculate the number of pairs for each domino frequency
        for (int freq : map.values()) {
            // The number of pairs is C(freq, 2) = freq * (freq - 1) / 2
            res += freq * (freq - 1) / 2;
        }
        
        return res;
    }
}