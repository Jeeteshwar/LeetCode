class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        int largestGroupSize = 0;

        for (int number = 1; number <= n; number++) {
            int digitSum = 0, current = number;
            while (current > 0) {
                digitSum += current % 10;
                current /= 10;
            }
            mp.put(digitSum, mp.getOrDefault(digitSum, 0) + 1);
            largestGroupSize = Math.max(largestGroupSize, mp.get(digitSum));
        }

        int largestGroupCount = 0;
        for (int frequency : mp.values()) {
            if (frequency == largestGroupSize) {
                largestGroupCount++;
            }
        }
        return largestGroupCount;
    }
}
