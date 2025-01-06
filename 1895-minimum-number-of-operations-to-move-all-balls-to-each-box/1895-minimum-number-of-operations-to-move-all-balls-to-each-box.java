class Solution {
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] operations = new int[length];

        int leftBallCount = 0;
        int leftDistanceSum = 0;

        for (int i = 0; i < length; ++i) {
            operations[i] = leftBallCount * i - leftDistanceSum;
            if (boxes.charAt(i) == '1') {
                ++leftBallCount;
                leftDistanceSum += i;
            }
        }

        int rightBallCount = 0;
        int rightDistanceSum = 0;

        for (int i = length - 1; i >= 0; --i) {
            operations[i] += rightDistanceSum - rightBallCount * i;
            if (boxes.charAt(i) == '1') {
                ++rightBallCount;
                rightDistanceSum += i;
            }
        }

        return operations;
    }
}
