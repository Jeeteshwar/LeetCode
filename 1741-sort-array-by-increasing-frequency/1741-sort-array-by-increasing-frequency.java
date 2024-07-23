class Solution {
    public int[] frequencySort(int[] nums) {
        // Array to count the frequency of each number in the range -100 to 100.
        int[] count = new int[201];
        
        // Count the frequency of each number in the input array.
        for (int num : nums) {
            count[num + 100]++;
        }
        
        // Convert the int array to an Integer array for sorting.
        Integer[] numsArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        // Sort the array using a custom comparator.
        Arrays.sort(numsArr, (a, b) -> {
            // Compare the frequencies of the two numbers.
            if (count[a + 100] == count[b + 100]) {
                // If frequencies are the same, sort by the numbers in descending order.
                return b - a;
            }
            // Otherwise, sort by frequencies in ascending order.
            return count[a + 100] - count[b + 100];
        });
        
        // Convert the sorted Integer array back to an int array.
        return Arrays.stream(numsArr).mapToInt(Integer::intValue).toArray();
    }
}