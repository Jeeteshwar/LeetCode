class Solution {
    private int getMaxConsecutiveCount(int[] bars) {
        int consecutiveCount = 2;
        int maxLength = 2;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] - bars[i - 1] == 1) {
                consecutiveCount++;
            } else {
                consecutiveCount = 2;
            }
            maxLength = Math.max(maxLength, consecutiveCount);
        }
        
        return maxLength;
    }
    
    public int maximizeSquareHoleArea(int horizontalBars, int verticalBars, 
                                      int[] horizontalRemovable, int[] verticalRemovable) {
        Arrays.sort(horizontalRemovable);
        Arrays.sort(verticalRemovable);
        
        int maxHorizontalGap = getMaxConsecutiveCount(horizontalRemovable);
        int maxVerticalGap = getMaxConsecutiveCount(verticalRemovable);
        
        int squareSide = Math.min(maxHorizontalGap, maxVerticalGap);
        return squareSide * squareSide;
    }
}