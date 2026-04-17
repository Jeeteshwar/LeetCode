import java.util.*;

class Solution {

    private int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res = Math.min(res, i - map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}