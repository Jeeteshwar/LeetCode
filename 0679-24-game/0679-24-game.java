class Solution {
    private static final double EPS = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return dfs(nums);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) 
            return Math.abs(nums.get(0) - TARGET) < EPS;

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                double a = nums.get(i), b = nums.get(j);

                // Try all possible results
                List<Double> candidates = new ArrayList<>();
                candidates.add(a + b);
                candidates.add(a - b);
                candidates.add(b - a);
                candidates.add(a * b);
                if (Math.abs(b) > EPS) candidates.add(a / b);
                if (Math.abs(a) > EPS) candidates.add(b / a);

                for (double val : candidates) {
                    next.add(val);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
