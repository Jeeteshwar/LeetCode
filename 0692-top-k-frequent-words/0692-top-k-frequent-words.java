import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Define the priority queue with custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> map.get(a).equals(map.get(b)) 
            ? a.compareTo(b) : map.get(b) - map.get(a));

        // Add all words to the priority queue
        pq.addAll(map.keySet());

        // Retrieve the top k frequent words
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
