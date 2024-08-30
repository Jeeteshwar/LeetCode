import java.math.BigInteger;

class Solution {
    public String addStrings(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        BigInteger add1 = BigInteger.ZERO;
        BigInteger add2 = BigInteger.ZERO;
        

        // Sum the digits of num1
        for (char n1 : nums1) {
            add1 = add1.multiply(BigInteger.TEN).add(BigInteger.valueOf(n1 - '0'));
        }

        // Sum the digits of num2
        for (char n2 : nums2) {
            add2 = add2.multiply(BigInteger.TEN).add(BigInteger.valueOf(n2 - '0'));
        }

        // Calculate the final sum and return it as a string
        return add1.add(add2).toString();
    }
}
