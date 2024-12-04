class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n =  str1.length();
        int m =  str2.length();
        int i = 0 , j = 0;

        while(i < n && j < m){
            if(str1.charAt(i) == str2.charAt(j) ||  // if normally charAt i and j are same
                str1.charAt(i)+1  == str2.charAt(j) || // if we need to goto one after the curr char eg: a -> b
                str1.charAt(i)-25 == str2.charAt(j)){ // if we face z to a (using ascii 122-25 to take us at once again a {as asked in question})
                j++; // if above passes through then only increment the j pointer
            }

            i++; // i will always increment
        }
        return j == m; // if the j pointer reaches the last digit of str2 then it will reutrn a true as boolean or a false as boolean in the case of not reaching 
    }
}