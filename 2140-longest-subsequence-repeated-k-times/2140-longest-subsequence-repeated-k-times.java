class Solution {
    public boolean isSubsequenceRepeatedK(String subsequence, String inputString, int repeatCount) {
        int subsequenceIndex = 0, repeatMatchCount = 0;
        for (char currentChar : inputString.toCharArray()) {
            if (currentChar == subsequence.charAt(subsequenceIndex)) {
                subsequenceIndex++;
                if (subsequenceIndex == subsequence.length()) {
                    subsequenceIndex = 0;
                    repeatMatchCount++;
                    if (repeatMatchCount == repeatCount) return true;
                }
            }
        }
        return false;
    }

    public String longestSubsequenceRepeatedK(String inputString, int repeatCount) {
        String longestSubsequence = "";
        Queue<String> subsequenceQueue = new LinkedList<>();
        subsequenceQueue.add("");

        while (!subsequenceQueue.isEmpty()) {
            String currentSubsequence = subsequenceQueue.poll();
            for (char currentChar = 'a'; currentChar <= 'z'; currentChar++) {
                String nextSubsequenceCandidate = currentSubsequence + currentChar;
                if (isSubsequenceRepeatedK(nextSubsequenceCandidate, inputString, repeatCount)) {
                    longestSubsequence = nextSubsequenceCandidate;
                    subsequenceQueue.add(nextSubsequenceCandidate);
                }
            }
        }
        return longestSubsequence;
    }
}