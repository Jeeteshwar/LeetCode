class Solution {
    public boolean detectCapitalUse(String str) {
        for (char c : str.toCharArray()) {
            if (str.equals(str.toLowerCase())) 
            return true;

         else if (Character.isUpperCase(str.charAt(0)) && 
            str.substring(1).equals(str.substring(1).toLowerCase())) {
            return true;
        }
         else if(!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
}