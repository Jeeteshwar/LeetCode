class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n =  nums1.length;
        int m = nums2.length;

        int hasSeen = 0;
        int count = 0;
        int i = 0;
        int j = 0;
                while(i < n && j < m){
                if(nums1[i] <= nums2[j]) {
                 count= Math.max(count, j - i);
                 j++;
                }
                else{
                    i++;
                }
                
            }
        
        return count;
    }
}