class Solution {
    public int minNumberOperations(int[] target) {
        final int arrayLength = target.length;
        int totalOperations = target[0];
        
        for (int i = 1; i < arrayLength; i++) {
            totalOperations += Math.max(target[i] - target[i - 1], 0);
        }
        
        return totalOperations;
    }
}