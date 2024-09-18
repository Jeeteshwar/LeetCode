class Solution {
    public String largestNumber(int[] nums) {
        List <String> stringNumbers = new ArrayList<>(); // converting the int array into string array

        for(int num : nums){ // traversing into the array nums to convert it into string
            stringNumbers.add(String.valueOf(num)); // converts the int values into the string values
        }

        stringNumbers.sort((str1 , str2) -> (str2 + str1).compareTo(str1 + str2));  
            //custom lamda sorting that comapres 2 elements lexicologically (eq 30 to 34) ->  3430 is greater than 3034
            // it places the largest element at starting

        // edge case if the first element after sort is 0 (all elements in the string is zero)
        if ("0".equals(stringNumbers.get(0))) {
            return "0"; // return 0 if 0 is equal to 1st element
        }

        return String.join("" , stringNumbers); // joining the string into the string format as asked in questions
    }
}