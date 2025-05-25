class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean hasCenter = false;

        for (String word : count.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (!word.equals(rev)) {
                if (count.containsKey(rev)) {
                    int pairs = Math.min(count.get(word), count.get(rev));
                    length += pairs * 4;
                    count.put(word, count.get(word) - pairs);
                    count.put(rev, count.get(rev) - pairs);
                }
            } else {
                int pairs = count.get(word) / 2;
                length += pairs * 4;
                count.put(word, count.get(word) % 2);
                if (count.get(word) == 1) hasCenter = true;
            }
        }

        if (hasCenter) length += 2;

        return length;
    }
}
