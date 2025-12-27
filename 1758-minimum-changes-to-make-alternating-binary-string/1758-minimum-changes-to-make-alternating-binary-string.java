class Solution {
    public int minOperations(String s) {
        int startZero = 0; //010101
        int startOne = 0;//101010

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (i % 2 == 0) { //even
                if (curr == '0') startOne++; //expects a 0 at even idx -> so startZero++
                else if (curr == '1') startZero++;  //expects a 1 at even idx -> so startOne++
        } else { //odd
                if (curr == '1') startOne++; //expects a 1 at odd idx -> so startZero++
                else if (curr ==  '0') startZero++;  //expects a 0 at odd idx -> so startOne++
            } 
        }

        return Math.min(startZero, startOne);
    }
}
