class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        List<Integer> frequencies = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                frequencies.add(f);
            }
        }
        Collections.sort(frequencies);
        
        int minDeletions = Integer.MAX_VALUE;
        int n = frequencies.size();
        
        for (int i = 0; i < n; i++) {
            int target = frequencies.get(i);
            int totalDeletions = 0;
            for (int j = 0; j < n; j++) {
                int current = frequencies.get(j);
                if (current < target) {
                    totalDeletions += current;
                } else if (current > target + k) {
                    totalDeletions += current - (target + k);
                }
            }
            if (totalDeletions < minDeletions) {
                minDeletions = totalDeletions;
            }
        }
        
        return minDeletions;
    }
}