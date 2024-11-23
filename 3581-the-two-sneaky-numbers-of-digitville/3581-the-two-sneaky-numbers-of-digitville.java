class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap <>();
        ArrayList<Integer> res = new ArrayList <>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()){
            if(map.get(num) > 1){
                res.add(num);
            }
        }
        int [] result = new int [res.size()];
        for(int i = 0 ; i < res.size() ; i++){
            result[i] = res.get(i);
        }
        return result;
    }
}