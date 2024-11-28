class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n =  candies.length;
        ArrayList<Boolean> res = new ArrayList <>();
        int max  = 0;

        for(int num :candies ){
            if(num > max){
                max = num;
            }
        }
        for (int i = 0 ; i < n ; i++){
            if(candies[i] + extraCandies >= max){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}