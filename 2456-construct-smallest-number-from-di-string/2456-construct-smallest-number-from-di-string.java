import java.util.Stack;

class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            stack.push(num++);
            
            if (ch == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        // Push the last number
        stack.push(num);
        
        // Pop all remaining numbers from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }
}