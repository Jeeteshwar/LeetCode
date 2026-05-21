class Node {
    Map<Integer, Node> umc = new HashMap<>();
    boolean isEnd = false;
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    // Inserting values into the trie
    public void insert(int a) {
        Node cur = root;
        String tmp = Integer.toString(a);
        for (int i = 0; i < tmp.length(); i++) {
            int num = tmp.charAt(i) - '0';
            if (!cur.umc.containsKey(num)) {
                cur.umc.put(num, new Node());
            }
            cur = cur.umc.get(num);
        }
        cur.isEnd = true; // Denotes no node after this
    }

    // Matching the prefixes of a string/number
    public int prefixMatch(int b) {
        Node cur = root;
        String tmp = Integer.toString(b); // Converting to string for easy traversal
        int len = 0;
        for (int i = 0; i < tmp.length(); i++) {
            int num = tmp.charAt(i) - '0';
            // If no match is found, break
            if (!cur.umc.containsKey(num)) {
                break;
            }
            cur = cur.umc.get(num);
            len++;
        }
        return len;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();
        for (int val : arr1) {
            t.insert(val);
        }

        int mx = Integer.MIN_VALUE;
        for (int val : arr2) {
            mx = Math.max(mx, t.prefixMatch(val));
        }

        return mx;
    }
}