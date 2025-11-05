class Solution {

    public int compare(int[] pair1, int[] pair2) {
        if (pair1[0] != pair2[0]) return Integer.compare(pair1[0], pair2[0]);
        return Integer.compare(pair1[1], pair2[1]);
    }

    public void insertIntoSet(TreeSet<int[]> primarySet, TreeSet<int[]> secondarySet, int[] pair, int x, long[] totalSum) {
        if (primarySet.size() < x || compare(pair, primarySet.first()) > 0) {
            primarySet.add(pair);
            totalSum[0] += (long) pair[0] * pair[1];
            if (primarySet.size() > x) {
                int[] smallest = primarySet.pollFirst();
                totalSum[0] -= (long) smallest[0] * smallest[1];
                secondarySet.add(smallest);
            }
        } else {
            secondarySet.add(pair);
        }
    }

    public void removeFromSet(TreeSet<int[]> primarySet, TreeSet<int[]> secondarySet, int[] pair, int x, long[] totalSum) {
        if (primarySet.remove(pair)) {
            totalSum[0] -= (long) pair[0] * pair[1];
            if (!secondarySet.isEmpty()) {
                int[] largest = secondarySet.pollLast();
                primarySet.add(largest);
                totalSum[0] += (long) largest[0] * largest[1];
            }
        } else {
            secondarySet.remove(pair);
        }
    }

    public long[] findXSum(int[] nums, int windowSize, int x) {
        int length = nums.length;
        long[] currentSum = new long[1];

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        Comparator<int[]> pairComparator = (pair1, pair2) -> {
            if (pair1[0] != pair2[0]) return Integer.compare(pair1[0], pair2[0]);
            return Integer.compare(pair1[1], pair2[1]);
        };

        TreeSet<int[]> primarySet = new TreeSet<>(pairComparator);
        TreeSet<int[]> secondarySet = new TreeSet<>(pairComparator);

        long[] result = new long[length - windowSize + 1];
        int left = 0;
        int right = 0;

        while (right < length) {
            int currentNum = nums[right];
            int oldFrequency = frequencyMap.getOrDefault(currentNum, 0);

            if (oldFrequency > 0) {
                removeFromSet(primarySet, secondarySet, new int[]{oldFrequency, currentNum}, x, currentSum);
            }
            
            frequencyMap.put(currentNum, oldFrequency + 1);

            insertIntoSet(primarySet, secondarySet, new int[]{oldFrequency + 1, currentNum}, x, currentSum);

            if (right - left + 1 == windowSize) {
                result[left] = currentSum[0];

                int outgoingNum = nums[left];
                int outgoingFrequency = frequencyMap.get(outgoingNum);
                removeFromSet(primarySet, secondarySet, new int[]{outgoingFrequency, outgoingNum}, x, currentSum);

                if (outgoingFrequency == 1) {
                    frequencyMap.remove(outgoingNum);
                } else {
                    frequencyMap.put(outgoingNum, outgoingFrequency - 1);
                    insertIntoSet(primarySet, secondarySet, new int[]{outgoingFrequency - 1, outgoingNum}, x, currentSum);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}