class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> sss = new Stack<>();
        int res = 0;
        for (int n : nums) {
            while (!sss.isEmpty() && sss.peek() > n)
                sss.pop();
            if (n == 0)
                continue;
            if (sss.isEmpty() || sss.peek() < n) {
                res++;
                sss.push(n);
            }
        }
        return res;
    }
}