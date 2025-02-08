import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexMap;  // Maps index -> number
    private Map<Integer, TreeSet<Integer>> numMap;  // Maps number -> sorted set of indices

    public NumberContainers() {
        indexMap = new HashMap<>();
        numMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            if (oldNumber != number) {
                numMap.get(oldNumber).remove(index);
                if (numMap.get(oldNumber).isEmpty()) {
                    numMap.remove(oldNumber);
                }
            }
        }
        indexMap.put(index, number);
        numMap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if (numMap.containsKey(number) && !numMap.get(number).isEmpty()) {
            return numMap.get(number).first();  // Smallest index for given number
        }
        return -1;
    }
}


