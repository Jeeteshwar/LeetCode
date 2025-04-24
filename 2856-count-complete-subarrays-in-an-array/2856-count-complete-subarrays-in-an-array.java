import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }
        int total = 0;
        int n = nums.length;
        int distinctCount = distinct.size();

        for (int i = 0; i < n; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                currentSet.add(nums[j]);
                if (currentSet.size() == distinctCount) {
                    total++;
                }
            }
        }

        return total;
    }
}
