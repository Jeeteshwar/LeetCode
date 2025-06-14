class Solution {
    public int minMaxDifference(int num) {
        char replaceMaxDigit = '*';
        StringBuilder maxNumber = new StringBuilder(String.valueOf(num));

        // Find first digit < 9 to replace with 9
        for (char digit : maxNumber.toString().toCharArray()) {
            if (digit - '0' < 9) {
                replaceMaxDigit = digit;
                break;
            }
        }

        // Replace all occurrences of replaceMaxDigit with '9'
        for (int i = 0; i < maxNumber.length(); i++) {
            if (maxNumber.charAt(i) == replaceMaxDigit) {
                maxNumber.setCharAt(i, '9');
            }
        }

        char replaceMinDigit = '*';
        StringBuilder minNumber = new StringBuilder(String.valueOf(num));

        // Find first digit > 0 to replace with 0
        for (char digit : minNumber.toString().toCharArray()) {
            if (digit - '0' > 0) {
                replaceMinDigit = digit;
                break;
            }
        }

        // Replace all occurrences of replaceMinDigit with '0'
        for (int i = 0; i < minNumber.length(); i++) {
            if (minNumber.charAt(i) == replaceMinDigit) {
                minNumber.setCharAt(i, '0');
            }
        }

        int maxVal = Integer.parseInt(maxNumber.toString());
        int minVal = Integer.parseInt(minNumber.toString());

        return maxVal - minVal;
    }
}
