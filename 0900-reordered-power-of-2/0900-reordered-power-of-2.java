import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            powers.add(1 << i); // 2^i
        }

        String nStr = String.valueOf(n);
        int l = nStr.length();
        List<Integer> possible = new ArrayList<>();
        Map<Character, Integer> realCount = new HashMap<>();

        for (int i = 0; i < l; i++) {
            char c = nStr.charAt(i);
            realCount.put(c, realCount.getOrDefault(c, 0) + 1);
        }

        for (int power : powers) {
            if (String.valueOf(power).length() == l) {
                possible.add(power);
            }
        }

        for (int power : possible) {
            Map<Character, Integer> checkCount = new HashMap<>();
            String powerStr = String.valueOf(power);
            for (int i = 0; i < powerStr.length(); i++) {
                char c = powerStr.charAt(i);
                checkCount.put(c, checkCount.getOrDefault(c, 0) + 1);
            }
            if (checkCount.equals(realCount)) {
                return true;
            }
        }

        return false;
    }
}
