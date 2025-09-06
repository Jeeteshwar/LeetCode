class Solution {
    public int[] countBits(int n) {
        int [] arr = new int [n + 1];
        arr[0] = 0;
        while(n != 0){
            int ones = Integer.bitCount(n);
            arr[n] = ones;
            n--;
        }
        return arr;
    }
}