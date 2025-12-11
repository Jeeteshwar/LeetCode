class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rows.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            cols.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        for (List<Integer> l : rows.values()) Collections.sort(l);
        for (List<Integer> l : cols.values()) Collections.sort(l);
        int cnt = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            List<Integer> row = rows.get(x);
            int idxRow = Collections.binarySearch(row, y);
            if (idxRow <= 0 || idxRow >= row.size() - 1) continue;
            List<Integer> col = cols.get(y);
            int idxCol = Collections.binarySearch(col, x);
            if (idxCol <= 0 || idxCol >= col.size() - 1) continue;
            cnt++;
        }
        return cnt;
    }
}
