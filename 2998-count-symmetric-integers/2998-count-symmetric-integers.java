class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for(int num = low ; num <= high ; num++){
            String s = Integer.toString(num);
            int n = s.length();

            if(n % 2 != 0){
                continue;
            }
        int half = n / 2;
        int firstHalf = 0;
        int seconfHalf = 0;

        for(int i = 0 ; i < half ; i++){
            firstHalf += Character.getNumericValue(s.charAt(i));
        }
        for(int i = half ; i < n ; i++){
            seconfHalf += Character.getNumericValue(s.charAt(i));
        }
        if(firstHalf == seconfHalf)
            count++;
        }
        return count;
    }
}