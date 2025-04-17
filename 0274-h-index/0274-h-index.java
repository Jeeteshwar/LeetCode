class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        
        int h_idx = 0;
        int n = citations.length;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(citations[i] > h_idx){
                h_idx++;
            }
            else{
                break;
            }
        }
        return h_idx;
    }
}