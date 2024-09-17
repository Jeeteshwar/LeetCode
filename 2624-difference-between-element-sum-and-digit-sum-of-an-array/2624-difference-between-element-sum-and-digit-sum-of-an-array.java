class Solution {
    public int differenceOfSum(int[] nums) {
        // Initialize an empty string to store concatenated numbers
        String digit = "";
        // Variables to store the sum of digits and the sum of elements
        int digitSum = 0;
        int elementSum = 0;
        
        // Iterate over each number in the input array
        for(int num : nums){
            // Add the number to the sum of elements
            elementSum += num;
            // Concatenate the number to the 'digit' string
            digit += num;
        }
            
        // Iterate over each character in the concatenated string 'digit'
        for(int i = 0 ; i < digit.length() ; i++){
            // Convert character to integer and add to digitSum
            digitSum += digit.charAt(i) - '0';
        }

        // Return the difference between the sum of elements and the sum of digits
        return elementSum - digitSum;
    }
}
