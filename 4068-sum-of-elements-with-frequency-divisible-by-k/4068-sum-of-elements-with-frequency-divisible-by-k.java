class Solution {
    public int sumDivisibleByK(int[] nums, int k) {

        int [] freq = new int [101];
        for(int num : nums){
            freq[num]++;
        }
        int sum = 0;
        // Sum elements whose frequency is divisible by k
        for(int i = 1 ; i <= 100 ; i++){
            if(freq[i] % k == 0){
                sum += i * freq[i];
            }
        }
        
        return sum;
    }
}
