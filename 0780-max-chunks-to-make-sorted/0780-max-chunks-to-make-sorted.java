class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int count = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max,arr[i]);
            // if the max == i , means that it is on the current correct position
            if(max == i){
                count++;
            }
        }
        return count;
    }
}