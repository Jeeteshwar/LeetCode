import java.util.HashSet;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        
        // Add all existing binary strings to a set for quick lookup
        for (String num : nums) {
            set.add(num);
        }
        
        // Iterate through all possible binary strings of length n
        for (int i = 0; i < (1 << n); i++) {
            String binaryString = Integer.toBinaryString(i);
            // Pad the binary string with leading zeros if necessary
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }
            // If the binary string is not in the set, return it
            if (!set.contains(binaryString)) {
                return binaryString;
            }
        }
        
        // If all binary strings are in the set, return an empty string (though the problem guarantees a solution)
        return "";
    }
}