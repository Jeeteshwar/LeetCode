class Solution {
    public boolean canSortArray(int[] arr) {
        int n = arr.length;

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++ ){
                if(arr[j] < arr[i]){
                    if(Integer.bitCount(arr[i]) != Integer.bitCount(arr[j])){
                        return false;
                    }
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //for(int k = 0 ; k < n-1 ; k++){
           // if(arr[k] > arr[k + 1]){
              //  return false;
           // }
      //  }
        return true;
    }
}