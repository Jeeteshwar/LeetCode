class Solution {
    public int takeCharacters(String s, int k) {
        int[] frequency = new int[3];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        if (min3(frequency[0], frequency[1], frequency[2]) < k)
            return -1;
        int Steps = Integer.MAX_VALUE, l = 0, n = s.length();
        for (int r = 0; r < n; r++) {
            frequency[s.charAt(r) - 'a']--;
            while (l < n && min3(frequency[0], frequency[1], frequency[2]) < k) {
                frequency[s.charAt(l) - 'a']++;
                l++;
            }
            Steps = Math.min(Steps, n - (r - l + 1));
        }
        return Steps;
    }
    private int min3(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}