class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : banned){
            set.add(num);
        }

        int sum = 0 , count = 0;

        for(int i = 1 ; i <= n ; i++) // eg:1 to n
        if(!set.contains(i) && sum + i <= maxSum){ // checking if it has banned element and the sum not getting out of range of maxSum
            sum+=i; // adding all the ith into sum to keep the count of the current sum;
            count++; // increment the count of the var as we seen the desired count
        }
        return count; // return the count
    }
}