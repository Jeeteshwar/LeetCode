class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;
        
        while (count < n) {
            // Generate odd-length palindromes
            List<Long> palindromes = generatePalindromes(length);
            for (long num : palindromes) {
                if (isPalindromeInBaseK(num, k)) {
                    sum += num;
                    count++;
                    if (count == n) {
                        return sum;
                    }
                }
            }
            length++;
        }
        
        return sum;
    }
    
    private List<Long> generatePalindromes(int length) {
        List<Long> palindromes = new ArrayList<>();
        if (length == 1) {
            for (long i = 1; i <= 9; i++) {
                palindromes.add(i);
            }
            return palindromes;
        }
        
        int halfLength = (length + 1) / 2;
        long start = (long) Math.pow(10, halfLength - 1);
        long end = (long) Math.pow(10, halfLength);
        
        for (long i = start; i < end; i++) {
            String half = Long.toString(i);
            String palindromeStr;
            if (length % 2 == 0) {
                palindromeStr = half + new StringBuilder(half).reverse().toString();
            } else {
                palindromeStr = half + new StringBuilder(half.substring(0, half.length() - 1)).reverse().toString();
            }
            palindromes.add(Long.parseLong(palindromeStr));
        }
        
        return palindromes;
    }
    
    private boolean isPalindromeInBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        long n = num;
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String baseKStr = sb.toString();
        return isPalindrome(baseKStr);
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}