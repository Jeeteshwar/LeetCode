class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;

        int [] Total =  new int [501];
        for(int num : arr){
            Total[num]++;
        }

        for(int i = 500 ; i > 0 ; i--){
            if(i == Total[i]){
                return i;
            }
        }
        return -1;
    }
}