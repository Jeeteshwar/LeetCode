class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Use two pointers approach
        int i = 0; // pointer for nums1
        int j = 0; // pointer for nums2
        List<int[]> resultList = new ArrayList<>();
        
        // While we haven't reached the end of either array
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                // If IDs match, add values together
                resultList.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                // If nums1 ID is smaller, add nums1 entry
                resultList.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                // If nums2 ID is smaller, add nums2 entry
                resultList.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        
        // Add remaining elements from nums1, if any
        while (i < nums1.length) {
            resultList.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        
        // Add remaining elements from nums2, if any
        while (j < nums2.length) {
            resultList.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        
        // Convert List to array
        int[][] result = new int[resultList.size()][2];
        for (int k = 0; k < resultList.size(); k++) {
            result[k] = resultList.get(k);
        }
        
        return result;
    }
}