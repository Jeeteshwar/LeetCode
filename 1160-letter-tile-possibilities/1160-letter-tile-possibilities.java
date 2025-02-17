class Solution {
    private int countPossibilities(int[] letterCounts) {
        int totalPossibilities = 0;
        for (int i = 0; i < 26; i++) {
            if (letterCounts[i] > 0) {
                totalPossibilities++;
                letterCounts[i]--;
                totalPossibilities += countPossibilities(letterCounts);
                letterCounts[i]++;
            }
        }
        return totalPossibilities;
    }

    public int numTilePossibilities(String tiles) {
        int[] letterCounts = new int[26];
        for (char tile : tiles.toCharArray()) {
            letterCounts[tile - 'A']++;
        }
        return countPossibilities(letterCounts);
    }
}