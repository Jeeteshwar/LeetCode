class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        long[] avail = new long[n];
        int[] cnt = new int[n];
        for (int[] m : meetings) {
            long s = m[0], e = m[1];
            long earliestTime = Long.MAX_VALUE;
            int earliestRoom = -1;
            boolean takeRoom = false;
            for (int room = 0; room < n; room++) {
                if (avail[room] < earliestTime) {
                    earliestTime = avail[room];
                    earliestRoom = room;
                }
                if (avail[room] <= s) {
                    takeRoom = true;
                    avail[room] = e;
                    cnt[room]++;
                    break;
                }
            }
            if (!takeRoom) {
                cnt[earliestRoom]++;
                avail[earliestRoom] += (e - s);
            }
        }
        int best = 0;
        for (int i = 1; i < n; i++) {
            if (cnt[i] > cnt[best]) best = i;
        }
        return best;
    }
}