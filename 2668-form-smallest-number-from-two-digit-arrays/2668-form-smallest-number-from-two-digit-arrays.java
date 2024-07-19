class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); //Sorting the array nums1
        Arrays.sort(nums2); //Sorting the array nums2
 
        int n1 = nums1.length; // length of nums1
        int n2 = nums2.length; // length of nums2

        //Traversing the both arrays
        for(int i = 0 ; i < n1 ; i++) 
        {
            for(int j = 0 ; j < n2 ; j++){
                if(nums1[i] == nums2[j]) return nums1[i]; // If in both any element are same return it
            }
        }
        
        int min = Math.min(nums1[0] , nums2[0]); // Getting the minimum element from the both
        int max = Math.max(nums1[0] , nums2[0]); // Getting the maximum element from the both

        return (min * 10 + max);        // forms a two-digit number where min is the tens 
                                        //  place and max is the units place.   
    }
}