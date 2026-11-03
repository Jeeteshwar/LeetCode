class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];

            if(nums[i] > max){
                max = nums[i];
            }
        }
        
        return max * n - sum;
    }
}

// class Solution {
//     public int minMoves(int[] nums) {
//         int n = nums.length;
//         int max = 0;
//         int ans = 0;

//         for(int i = 0; i < n; i++){
//             if(nums[i] > max){
//                 max = nums[i];
//             }
//         }

//         for(int i = 0; i < n; i++){
//             ans += max - nums[i];
//         }

//         return ans;
//     }
// }