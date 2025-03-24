class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Merge overlapping meetings
        List<int[]> merged = new ArrayList<>();
        for (int[] meeting : meetings) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < meeting[0]) {
                merged.add(meeting);
            } else {
                merged.get(merged.size() - 1)[1] = 
                    Math.max(merged.get(merged.size() - 1)[1], meeting[1]);
            }
        }
        
        // Count total meeting days
        int meetingDays = 0;
        for (int[] interval : merged) {
            meetingDays += interval[1] - interval[0] + 1;
        }
        
        // Return days without meetings
        return days - meetingDays;
    }
}