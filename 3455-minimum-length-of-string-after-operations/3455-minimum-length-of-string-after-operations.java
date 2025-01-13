class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int ans = 0;

        int arr [] = new int [26];

        for(int i = 0 ; i < n ; i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] == 0){
                continue;
            }
            if(arr[i] % 2 != 0 ){
                ans++;
            }
            else{
                ans+=2;
            }
            
        }
        return ans;
    }
}