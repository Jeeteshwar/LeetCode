class Solution {
    public int maximumLength(int[] nums) {
        int altEven = 0;
        int altOdd = 0;
        int evenCount = 0;
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
                altEven = altOdd + 1;
            } else {
                oddCount++;
                altOdd = altEven + 1;
            }
        }
        return Math.max(Math.max(evenCount, oddCount), Math.max(altEven, altOdd));
    }
}