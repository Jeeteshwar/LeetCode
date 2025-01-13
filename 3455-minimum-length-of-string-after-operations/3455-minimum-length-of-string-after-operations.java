class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int ans = 0;

        int arr [] = new int [26];
        // FREQUENCY OF ALL ALPHABET
        for(int i = 0 ; i < n ; i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] == 0){  // IF ANY FREQUQNCY OF ALPHABET IS 0 SKIP 
                continue;
            }
            if(arr[i] % 2 != 0 ){ // IF FREQUENCY OF ALPHABET IS EVEN +1
                ans++;
            }
            else{ //IF OFF +2
                ans+=2;
            }
            
        }
        return ans; //RETURN ANS
    }
}