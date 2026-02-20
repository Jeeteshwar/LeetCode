class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0;
        int start = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) {
                String inner = s.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder res = new StringBuilder();
        for (String str : list) res.append(str);

        return res.toString();
    }
}