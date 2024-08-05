class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> mp = new HashMap<>();

        for(String v : arr){
            mp.put(v , mp.getOrDefault(v,0) + 1);
        }
        for(String v : arr){
            if(mp.get(v) == 1){
                --k;
                if(k == 0){
                    return v;
                }
            }
        }
        return "";
    }
}