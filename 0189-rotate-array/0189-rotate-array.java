class Solution {

    static void reverse(int [] arr, int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
         }
    }
    public void rotate(int[] arr, int k) {
        int n = arr.length;

        k %= n;
        int d =  n - k;

        reverse(arr , 0 , d-1);

        reverse(arr , d , n-1);

        reverse(arr , 0 , n-1);
    }
}