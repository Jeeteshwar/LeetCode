class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int minRotations = Integer.MAX_VALUE;
        
        // Try the values of the first domino as candidates
        int[] candidates = {tops[0], bottoms[0]};
        
        for (int target : candidates) {
            // Check if we can make all tops equal to target
            int topRotations = 0;
            boolean topPossible = true;
            
            // Check if we can make all bottoms equal to target
            int bottomRotations = 0;
            boolean bottomPossible = true;
            
            for (int i = 0; i < n; i++) {
                // Check for tops
                if (tops[i] != target) {
                    if (bottoms[i] == target) {
                        topRotations++; // Need to rotate this domino
                    } else {
                        topPossible = false; // Target not in this domino
                    }
                }
                
                // Check for bottoms
                if (bottoms[i] != target) {
                    if (tops[i] == target) {
                        bottomRotations++; // Need to rotate this domino
                    } else {
                        bottomPossible = false; // Target not in this domino
                    }
                }
            }
            
            // Update minimum rotations if configuration is possible
            if (topPossible) {
                minRotations = Math.min(minRotations, topRotations);
            }
            if (bottomPossible) {
                minRotations = Math.min(minRotations, bottomRotations);
            }
        }
        
        // Return -1 if no valid configuration found
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }
}