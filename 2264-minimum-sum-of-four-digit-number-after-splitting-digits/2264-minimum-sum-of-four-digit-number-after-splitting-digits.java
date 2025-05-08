class Solution {
    public int minimumSum(int num) {
        int[] res = new int[4]; // 10 is enough for an int
        int i = 0;

        // Extract digits and store in reverse
        while (num > 0) {
            res[i] = num % 10;
            num /= 10;
            i++;
        }
        int n = res.length;
        Arrays.sort(res);

        int new1 = res[0] * 10 + res[n-1];
        int new2 = res[1] * 10 + res[n-2];

        

        return new1 + new2;
    }
}
