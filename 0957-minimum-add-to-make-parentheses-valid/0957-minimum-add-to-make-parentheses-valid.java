class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){ // found a opening Parentheses
                open++;
            }
            else if(ch == ')' && open > 0){ //found a closing Parentheses 
                open--; // since the opening Parentheses was over 1 we need to decrement it because we found )
            }
            else{ //if we found a ) Parentheses and the count of opening is 0 so we need a opening Parentheses as we dont have its combination
                close++; 
            }
        }
        return close + open; //return close Parentheses + open Parentheses to cover all the combination
    }
}