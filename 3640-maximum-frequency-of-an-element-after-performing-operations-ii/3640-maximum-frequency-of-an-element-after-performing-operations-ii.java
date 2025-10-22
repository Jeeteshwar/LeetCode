import java.util.*;

class Solution {
    public int maxFrequency(int[] numbers, int maxDifference, int maxOperations) {
        int arrayLength = numbers.length;
        if (arrayLength == 0) return 0;
        Arrays.sort(numbers);

        Map<Long, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put((long)number, frequencyMap.getOrDefault((long)number, 0) + 1);
        }

        int maxFrequency = 1;

        for (Map.Entry<Long, Integer> entry : frequencyMap.entrySet()) {
            long currentValue = entry.getKey();
            int currentFrequency = entry.getValue();

            long lowerBoundValue = currentValue - maxDifference;
            long upperBoundValue = currentValue + maxDifference;
            int lowerIndex = findLowerBound(numbers, lowerBoundValue);
            int upperIndex = findUpperBound(numbers, upperBoundValue);
            int totalInRange = upperIndex - lowerIndex;
            int requiredOperations = totalInRange - currentFrequency;
            int possibleOperations = Math.min(requiredOperations, maxOperations);
            maxFrequency = Math.max(maxFrequency, currentFrequency + possibleOperations);
        }

        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < arrayLength; ++rightPointer) {
            while (leftPointer <= rightPointer && (long)numbers[rightPointer] - numbers[leftPointer] > 2L * maxDifference) {
                leftPointer++;
            }
            int windowSize = rightPointer - leftPointer + 1;
            maxFrequency = Math.max(maxFrequency, Math.min(windowSize, maxOperations));
        }

        return maxFrequency;
    }

    private int findLowerBound(int[] array, long target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if ((long)array[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int findUpperBound(int[] array, long target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if ((long)array[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}