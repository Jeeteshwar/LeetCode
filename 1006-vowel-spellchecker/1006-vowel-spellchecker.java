import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelError = new HashMap<>();
        
        for (String word : wordlist) {
            exactWords.add(word);
            
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            
            String devoweled = devowel(lower);
            vowelError.putIfAbsent(devoweled, word);
        }
        
        String[] result = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }
            
            String lower = query.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                result[i] = caseInsensitive.get(lower);
                continue;
            }
            
            String devoweled = devowel(lower);
            if (vowelError.containsKey(devoweled)) {
                result[i] = vowelError.get(devoweled);
            } else {
                result[i] = "";
            }
        }
        
        return result;
    }
    
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
