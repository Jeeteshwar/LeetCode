class Solution {
    public int sumBase(int n, int k) {
        int sum = 0;
        while(n>0){ // iterating the loop till the n becomes 0
            sum += n % k; // adding the current extarcted base from the n and adding it to the sum variable
            n/= k; // then deleting the the current digit from n by n = n / k 
                                                            // eg: n = 34 / 6 
                                                                // = 4
        }
        return sum;
    }
}