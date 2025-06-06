import java.util.*;

class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;

            while (!stack.isEmpty() && isSmallerOrEqual(stack.peek(), freq)) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    private boolean isSmallerOrEqual(char top, int[] freq) {
        for (int i = 0; i < top - 'a'; i++) {
            if (freq[i] > 0) return false;
        }
        return true;
    }
}
