class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int width, height;
        int[] heights = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            width = books[i - 1][0];
            height = books[i - 1][1];
            heights[i] = heights[i - 1] + height;
            for (int j = i - 1; j > 0; --j) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j - 1][1]);
                heights[i] = Math.min(heights[i], heights[j - 1] + height);
            }
        }
        return heights[n];
    }
}