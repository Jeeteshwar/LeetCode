class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L, high = 10000000000L;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessEqual(nums1, nums2, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                // count number of b in nums2 such that a * b <= x
                int left = 0, right = nums2.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if ((long) a * nums2[mid] <= x) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += left;
            } else if (a < 0) {
                // count number of b in nums2 such that a * b <= x
                int left = 0, right = nums2.length;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if ((long) a * nums2[mid] <= x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                count += nums2.length - left;
            } else { // a == 0
                if (x >= 0) count += nums2.length;
            }
        }
        return count;
    }
}
