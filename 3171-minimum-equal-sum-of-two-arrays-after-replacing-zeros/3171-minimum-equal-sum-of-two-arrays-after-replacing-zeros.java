class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long nums1_zero_count = 0;
        long nums2_zero_count = 0;

        long sum_num1 = 0;
        long sum_num2 = 0;

        for (int num : nums1) {
            sum_num1 += num;
            if (num == 0) {
                nums1_zero_count++;
                sum_num1 += 1;
            }
        }

        for (int num : nums2) {
            sum_num2 += num;
            if (num == 0) {
                nums2_zero_count++;
                sum_num2 += 1;
            }
        }

        if ((sum_num1 < sum_num2 && nums1_zero_count == 0) || 
            (sum_num2 < sum_num1 && nums2_zero_count == 0)) {
            return -1;
        }

        return Math.max(sum_num1, sum_num2);
    }
}
