class Solution {
    public int countSegments(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        
        // If the string is empty, return 0
        if (s.isEmpty()) {
            return 0;
        }
        
        // Split the string by one or more spaces
        String[] segments = s.split("\\s+");
        
        // Return the number of segments
        return segments.length;
    }
}