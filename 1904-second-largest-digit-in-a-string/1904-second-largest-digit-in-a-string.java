class Solution {
    public int secondHighest(String s) {
        HashSet<Integer> set = new HashSet <>();
        
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
           if(Character.isDigit(ch)) {
                set.add(Character.getNumericValue(ch));
        }
        }
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        if(arr.size() < 2) return -1;
        int res = arr.get(arr.size () - 2);

        return res;
    }
}