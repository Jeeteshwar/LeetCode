class Solution {
    public int makeTheIntegerZero(int startValue, int decrementStep) {
        for (int operations = 0; operations <= 60; operations++) {
            long remaining = (long) startValue - (long) operations * decrementStep;
            if (remaining < 0) continue;
            if (remaining < operations) continue;
            int bitCount = Long.bitCount(remaining);
            if (bitCount <= operations) return operations;
        }
        return -1;
    }
}
