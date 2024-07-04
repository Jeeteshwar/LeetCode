class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // Initialize a HashSet to keep track of unique numbers
        int xor = 0; // Initialize xor to 0; this will store the XOR of duplicate numbers
 
        for(int num : nums){  // Iterate through each number in the input array
            if(set.contains(num))  
                xor ^= num; // If the number is already in the set, it is a duplicate
            
            else
                set.add(num); // Attempt to add the number to the set
             
        }
        return xor;  // Return the final XOR value of all duplicates

       
            
        
    }
}