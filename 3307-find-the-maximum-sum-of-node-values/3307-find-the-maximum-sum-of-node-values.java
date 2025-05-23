class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        
        List<Integer> fayda=new ArrayList<>();

        long normalsum=0;

        for(int num:nums){

            fayda.add((num ^ k)-num);

            normalsum+=(long)num;

        }
        Collections.sort(fayda, Collections.reverseOrder());

        for(int i = 0 ; i< fayda.size() - 1 ; i+=2 ){
            long pairsum=fayda.get(i) + fayda.get(i+1);

            if(pairsum > 0) normalsum+=pairsum;
        }
        return normalsum;

    }
}