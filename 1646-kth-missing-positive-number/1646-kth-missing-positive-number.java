class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int i : arr){ // traversing through the array 
            if(i <= k) k++; // checking if the current i is less than the value of k
                            //initially it is 5 if the condition is true it will increment the k
                            
            else
                break; //if i > k that means we have crossed 5th element and return the current count of k
        }
        return k; //return k
    }
}