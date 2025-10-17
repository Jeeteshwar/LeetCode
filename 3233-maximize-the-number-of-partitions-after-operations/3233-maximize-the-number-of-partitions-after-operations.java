import java.util.*;

class Solution {
    private Map<Long, Integer> cache = new HashMap<>();
    private String input;
    private int maxUniqueChars;

    private int solve(int index, long usedMask, boolean canModify) {
        if (index == input.length()) return 0;

        long key = ((long) index << 27) | (usedMask << 1) | (canModify ? 1 : 0);
        if (cache.containsKey(key)) return cache.get(key);

        int currentChar = input.charAt(index) - 'a';
        long updatedMask = usedMask | (1L << currentChar);
        int partitions;

        if (Long.bitCount(updatedMask) > maxUniqueChars)
            partitions = 1 + solve(index + 1, 1L << currentChar, canModify);
        else
            partitions = solve(index + 1, updatedMask, canModify);

        if (canModify) {
            for (int letter = 0; letter < 26; letter++) {
                long modifiedMask = usedMask | (1L << letter);
                if (Long.bitCount(modifiedMask) > maxUniqueChars)
                    partitions = Math.max(partitions, 1 + solve(index + 1, 1L << letter, false));
                else
                    partitions = Math.max(partitions, solve(index + 1, modifiedMask, false));
            }
        }

        cache.put(key, partitions);
        return partitions;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        this.input = s;
        this.maxUniqueChars = k;
        cache.clear();
        return solve(0, 0, true) + 1;
    }
}
