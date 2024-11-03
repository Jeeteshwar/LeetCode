class Solution {
    public boolean rotateString(String s, String goal) {
        // Step 1: Get the lengths of the input strings `s` and `goal`.
        int n = s.length();
        int m = goal.length();

        // Step 2: Check if both strings have the same length
        // and if `goal` can be found in `s + s`.
        // Explanation:
        // - If the lengths are not the same, return false since a rotation
        //   of one string can't match another string with a different length.
        // - By doubling `s` (using `s + s`), we can check if `goal` is a rotated
        //   version of `s`. If `goal` is a rotation of `s`, it will appear as a 
        //   substring in `s + s`.
        if (m == n && (s + s).contains(goal)) {
            return true;  // `goal` is a rotation of `s`, so return true.
        }
        
        // Step 3: If `goal` is not a rotation of `s`, return false.
        return false;
    }
}
