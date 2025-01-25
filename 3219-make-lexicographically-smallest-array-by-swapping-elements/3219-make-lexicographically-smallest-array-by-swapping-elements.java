class Solution {
    public int[] lexicographicallySmallestArray(int[] inputArray, int differenceLimit) {
        int arrayLength = inputArray.length;
        int[] sortedArray = inputArray.clone();
        Arrays.sort(sortedArray);

        int currentGroup = 0;
        Map<Integer, Integer> valueToGroupMap = new HashMap<>();
        Map<Integer, LinkedList<Integer>> groupToValuesMap = new HashMap<>();

        valueToGroupMap.put(sortedArray[0], currentGroup);
        groupToValuesMap.putIfAbsent(currentGroup, new LinkedList<>());
        groupToValuesMap.get(currentGroup).add(sortedArray[0]);

        for (int i = 1; i < arrayLength; i++) {
            if (Math.abs(sortedArray[i] - sortedArray[i - 1]) > differenceLimit) {
                currentGroup++;
            }
            valueToGroupMap.put(sortedArray[i], currentGroup);
            groupToValuesMap.putIfAbsent(currentGroup, new LinkedList<>());
            groupToValuesMap.get(currentGroup).add(sortedArray[i]);
        }

        int[] resultArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int originalValue = inputArray[i];
            int groupNumber = valueToGroupMap.get(originalValue);
            resultArray[i] = groupToValuesMap.get(groupNumber).pollFirst(); // Use and remove the smallest element
        }

        return resultArray;
    }
}
