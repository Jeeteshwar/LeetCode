class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split both sentences into words using spaces as the delimiter
        String[] firststr = s1.split(" ");  // Split the first sentence into an array of words
        String[] secondstr = s2.split(" "); // Split the second sentence into an array of words

        // Create a HashMap to store each word and its frequency (how many times it appears)
        HashMap<String, Integer> map = new HashMap<>();

        // Loop through the words in the first sentence
        for (String val : firststr) {
            // If the word is already in the map, increment its count, otherwise add it with count 1
            if(map.containsKey(val))
                map.put(val, map.get(val)+1);
          else        
                map.put(val,1);
        }
        // Loop through the words in the second sentence
        for (String val : secondstr) {
            // Same as above: increment the count if the word is already in the map, otherwise add it with count 1
           if(map.containsKey(val))
                map.put(val, map.get(val)+1);
           else
                map.put(val, 1);
        }

        // Create a list to store words that appear exactly once across both sentences
        ArrayList<String> list = new ArrayList<>();

        // Loop through all the words (keys) in the map
        for (String str : map.keySet()) {
            // If a word appears only once (i.e., its count is 1), add it to the list
            if (map.get(str) == 1) {
                list.add(str);
            }
        }

        // Convert the list of uncommon words back into an array and return it
        return list.toArray(new String[0]);

    }
}
