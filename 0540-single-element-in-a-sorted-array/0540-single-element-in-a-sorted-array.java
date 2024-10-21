class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        HashMap <Integer , Integer> mp = new HashMap <>();
        
        for(int i = 0 ; i < n ; i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i] , mp.get(arr[i]) + 1);
            }    
            else{
                mp.put(arr[i] , 1);
            }
        }
        for(HashMap.Entry <Integer , Integer> entry : mp.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}