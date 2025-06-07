
class Solution {
    public String clearStars(String s) {
        StringBuilder stack = new StringBuilder();
        // Stores indices of each character in the stack
        ArrayDeque<Integer>[] positions = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayDeque<>();
        }

        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.append(c);
                positions[c - 'a'].addLast(stack.length() - 1);
            } else {
                // Find the lex smallest character with available positions
                for (int i = 0; i < 26; i++) {
                    if (!positions[i].isEmpty()) {
                        int idx = positions[i].pollLast(); // rightmost
                        stack.setCharAt(idx, '#'); // mark as removed
                        break;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.length(); i++) {
            if (stack.charAt(i) != '#') {
                result.append(stack.charAt(i));
            }
        }

        return result.toString();
    }
}
