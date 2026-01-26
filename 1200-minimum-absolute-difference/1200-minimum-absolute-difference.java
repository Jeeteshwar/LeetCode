class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;

        for(int i = 1 ; i < n ; i++){
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(diff , minDiff);
          }
        for(int i = 1 ; i < n ; i++){
            int diff = arr[i] - arr[i - 1];
            if(diff == minDiff){
                res.add(Arrays.asList(arr[i - 1] , arr[i]));
            }
        }
      
        return res;
    }
}