class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap <>();


        for(int num : nums){
            mp.put(num , mp.getOrDefault(num , 0) + 1);

        }

        ArrayList<Integer> result = new ArrayList <>();

        boolean found = false;

            for(HashMap.Entry<Integer , Integer> entry :mp.entrySet()){
                if(entry.getValue () > n / 3){
                    result.add(entry.getKey());
                    found = true;
                }
            }
        
        //if(!found){
         //   result.add(-1);
        //}
        return result;
    }
}