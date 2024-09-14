class Solution {

    public int gcd(int a , int b){
        while(b != 0 ){
            int temp = b;
            b = a % b;
            a = temp;

        }
        return a;
    }
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int smallest = nums[0];
        int largest = nums[n-1];
        int result = gcd(smallest , largest);


        return result;
    }
}