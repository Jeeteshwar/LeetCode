class Solution {
    public List<String> readBinaryWatch(int ledsOn) {
        List<String> timeList = new ArrayList<>();

        for (int hours = 0; hours < 12; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (Integer.bitCount(hours) + Integer.bitCount(minutes) == ledsOn) {
                    timeList.add(String.format("%d:%02d", hours, minutes));
                }
            }
        }

        return timeList;
    }
}
