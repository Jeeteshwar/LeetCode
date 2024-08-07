import java.util.*;

public class Solution {
    private static final List<Pair<Integer, String>> map = Arrays.asList(
        new Pair<>(1000000000, "Billion"),
        new Pair<>(1000000, "Million"),
        new Pair<>(1000, "Thousand"),
        new Pair<>(100, "Hundred"),
        new Pair<>(90, "Ninety"),
        new Pair<>(80, "Eighty"),
        new Pair<>(70, "Seventy"),
        new Pair<>(60, "Sixty"),
        new Pair<>(50, "Fifty"),
        new Pair<>(40, "Forty"),
        new Pair<>(30, "Thirty"),
        new Pair<>(20, "Twenty"),
        new Pair<>(19, "Nineteen"),
        new Pair<>(18, "Eighteen"),
        new Pair<>(17, "Seventeen"),
        new Pair<>(16, "Sixteen"),
        new Pair<>(15, "Fifteen"),
        new Pair<>(14, "Fourteen"),
        new Pair<>(13, "Thirteen"),
        new Pair<>(12, "Twelve"),
        new Pair<>(11, "Eleven"),
        new Pair<>(10, "Ten"),
        new Pair<>(9, "Nine"),
        new Pair<>(8, "Eight"),
        new Pair<>(7, "Seven"),
        new Pair<>(6, "Six"),
        new Pair<>(5, "Five"),
        new Pair<>(4, "Four"),
        new Pair<>(3, "Three"),
        new Pair<>(2, "Two"),
        new Pair<>(1, "One")
    );

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        for (Pair<Integer, String> entry : map) {
            if (num >= entry.getKey()) {
                String a = "";
                if (num >= 100) {
                    a = numberToWords(num / entry.getKey()) + " ";
                }
                
                String b = entry.getValue();
                String c = "";
                if (num % entry.getKey() != 0) {
                    c = " " + numberToWords(num % entry.getKey());
                }
                return a + b + c;
            }
        }
        return "";
    }
    
    // Helper class to store pairs of integers and strings
    static class Pair<K, V> {
        private final K key;
        private final V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
    }
}