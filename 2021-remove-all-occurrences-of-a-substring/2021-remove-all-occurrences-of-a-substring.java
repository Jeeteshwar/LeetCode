class Solution {
    public String removeOccurrences(String s, String part) {
        // Use StringBuilder for efficient string modification
        StringBuilder sb = new StringBuilder(s);

        // Continue removing 'part' as long as it exists in the string
        while (sb.indexOf(part) != -1) {
            // Find the starting index of 'part' in the string
            int idx = sb.indexOf(part);

            // Remove 'part' by deleting characters from index 'idx' to 'idx + part.length()'
            sb.delete(idx, idx + part.length());
        }

        // Convert StringBuilder back to a string and return the final result
        return sb.toString();
    }
}
