class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap <>();
        ArrayList<Integer> result = new ArrayList <>();

        for(int num : nums) mp.put(num , mp.getOrDefault(num , 0) + 1);
            
        
        boolean found = false;
               for(int num : mp.keySet()){

                if(mp.get(num) > n / 3){
                    result.add(num);
                    found = true;
                }
            }
     
        return result;
    }
}