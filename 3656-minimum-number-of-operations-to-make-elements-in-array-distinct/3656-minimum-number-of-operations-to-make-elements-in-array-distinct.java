class Solution {
    public int minimumOperations(int[] nums) {
        // Use a HashSet to track distinct elements.
        Set<Integer> set = new HashSet<>();
        
        int operations = 0; // To count the number of operations performed.
        int index = 0; // To track the current index in the array.

        while (index < nums.length) {
            // Add elements to the set to check for duplicates.
            set.clear();
            boolean hasDuplicates = false;

            for (int i = index; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    hasDuplicates = true;
                    break;
                }
                set.add(nums[i]);
            }

            // If duplicates are found, perform an operation to remove 3 elements.
            if (hasDuplicates) {
                operations++;
                index += 3;
            } else {
                break; // Array is distinct, exit the loop.
            }
        }

        return operations;
    }
}