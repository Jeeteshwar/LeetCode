class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;

        boolean found = false;

        ArrayList<Integer> result =  new ArrayList <>();
        String strAt =  String.valueOf(x);

        for(int i = 0 ; i < n ;i++){
            if(words[i].contains(strAt)){
                result.add(i);
            }
        }
        return result;
    }
}