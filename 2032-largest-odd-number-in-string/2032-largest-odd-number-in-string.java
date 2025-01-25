class Solution {
    public String largestOddNumber(String num) {
        // Start checking from the end of the string
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current character is an odd digit
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return the substring up to the current index (inclusive)
                return num.substring(0, i + 1);
            }
        }
        // No odd digit found, return an empty string
        return "";
    }
}
