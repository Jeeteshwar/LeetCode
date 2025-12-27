class Solution {
    public int minOperations(String s) {
        int startZero = 0;
        int startOne = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (i % 2 == 0) {
                if (curr != '0') startZero++;
                if (curr != '1') startOne++;
            } else {
                if (curr != '1') startZero++;
                if (curr != '0') startOne++;
            }
        }

        return Math.min(startZero, startOne);
    }
}
