class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        int max = 0;
        int maxI = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > max){
                max = arr[i];
                maxI = i;
            }
        }
        return maxI;
    }
}