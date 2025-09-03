import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Convert int[][] to List<int[]> for sorting
        List<int[]> list = new ArrayList<>();
        for (int[] point : points) {
            list.add(point);
        }
        
        // Sort by x ascending, then by y descending
        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int count = 0;
        int n = list.size();
        
        for (int i = 0; i < n; i++) {
            int y1 = list.get(i)[1];
            int minY = Integer.MIN_VALUE;
            
            for (int j = i + 1; j < n; j++) {
                int y2 = list.get(j)[1];
                
                if (y2 <= y1 && y2 > minY) {
                    count++;
                    minY = y2;
                    if (y2 == y1) break;
                }
            }
        }
        
        return count;
    }
}