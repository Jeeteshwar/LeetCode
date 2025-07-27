class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> filtered = new ArrayList<>();
        filtered.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                filtered.add(nums[i]);
            }
        }

        int count = 0;
        for (int i = 1; i < filtered.size() - 1; i++) {
            if ((filtered.get(i) > filtered.get(i - 1) && filtered.get(i) > filtered.get(i + 1)) ||
                (filtered.get(i) < filtered.get(i - 1) && filtered.get(i) < filtered.get(i + 1))) {
                count++;
            }
        }

        return count;
    }
}
