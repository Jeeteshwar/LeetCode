class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int maxNum = getMax(s);
        int minNum = getMin(s);
        return maxNum - minNum;
    }
    
    private int getMax(String s) {
        char[] chars = s.toCharArray();
        char target = ' ';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '9') {
                target = chars[i];
                break;
            }
        }
        if (target == ' ') {
            return Integer.parseInt(s);
        }
        String maxStr = s.replace(target, '9');
        return Integer.parseInt(maxStr);
    }
    
    private int getMin(String s) {
        char[] chars = s.toCharArray();
        char target = ' ';
        char replacement = ' ';
        if (chars[0] != '1') {
            target = chars[0];
            replacement = '1';
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != '0' && chars[i] != '1') {
                    target = chars[i];
                    replacement = '0';
                    break;
                }
            }
        }
        if (target == ' ') {
            return Integer.parseInt(s);
        }
        String minStr = s.replace(target, replacement);
        return Integer.parseInt(minStr);
    }
}