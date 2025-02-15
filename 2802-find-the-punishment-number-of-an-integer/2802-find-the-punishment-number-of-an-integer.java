class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canPartition(String.valueOf(square), i)) {
                sum += square;
            }
        }
        return sum;
    }

    private boolean canPartition(String s, int target) {
        return backtrack(s, target, 0, 0);
    }

    private boolean backtrack(String s, int target, int index, int currentSum) {
        if (index == s.length()) {
            return currentSum == target;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(index, i));
            if (currentSum + num > target) {
                break; // Early termination if the sum exceeds the target
            }
            if (backtrack(s, target, i, currentSum + num)) {
                return true;
            }
        }
        return false;
    }
}