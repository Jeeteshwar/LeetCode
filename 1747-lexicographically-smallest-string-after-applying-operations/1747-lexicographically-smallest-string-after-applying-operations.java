class Solution {
    public String findLexSmallestString(String s, int addValue, int rotateBy) {
        Set<String> visited = new HashSet<>();
        String smallestString = s;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.compareTo(smallestString) < 0) smallestString = current;

            // Operation 1: Add 'a' to odd indices
            StringBuilder stringBuilder = new StringBuilder(current);
            for (int i = 1; i < stringBuilder.length(); i += 2) {
                int digit = (stringBuilder.charAt(i) - '0' + addValue) % 10;
                stringBuilder.setCharAt(i, (char) (digit + '0'));
            }
            String addedString = stringBuilder.toString();
            if (visited.add(addedString)) queue.offer(addedString);

            // Operation 2: Rotate string by 'b' positions
            String rotatedString = current.substring(current.length() - rotateBy) + 
                                 current.substring(0, current.length() - rotateBy);
            if (visited.add(rotatedString)) queue.offer(rotatedString);
        }
        return smallestString;
    }
}