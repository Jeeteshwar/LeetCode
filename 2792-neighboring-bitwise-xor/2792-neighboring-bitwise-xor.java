class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xx = derived[0];
        for (int i = 1; i < derived.length; i++) {
            xx ^= derived[i];
        }
        return xx == 0;
    }
}