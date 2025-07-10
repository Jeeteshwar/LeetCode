class Solution {
    public int maxFreeTime(int eventEndTime, int[] eventStarts, int[] eventEnds) {
        int numEvents = eventStarts.length;
        if (numEvents == 0) return eventEndTime;

        int[] freeGaps = new int[numEvents + 1];
        freeGaps[0] = eventStarts[0];

        for (int i = 1; i < numEvents; i++) {
            freeGaps[i] = eventStarts[i] - eventEnds[i - 1];
        }
        freeGaps[numEvents] = eventEndTime - eventEnds[numEvents - 1];

        int[] maxGapToRight = new int[numEvents + 1];
        for (int i = numEvents - 1; i >= 0; i--) {
            maxGapToRight[i] = Math.max(maxGapToRight[i + 1], freeGaps[i + 1]);
        }

        int maxFreeTime = 0, maxGapToLeft = 0;
        for (int i = 1; i <= numEvents; i++) {
            int currentEventDuration = eventEnds[i - 1] - eventStarts[i - 1];
            boolean fitsInLeft = maxGapToLeft >= currentEventDuration;
            boolean fitsInRight = maxGapToRight[i] >= currentEventDuration;

            if (fitsInLeft || fitsInRight) {
                int totalMergedGap = freeGaps[i - 1] + freeGaps[i] + currentEventDuration;
                maxFreeTime = Math.max(maxFreeTime, totalMergedGap);
            }

            maxFreeTime = Math.max(maxFreeTime, freeGaps[i - 1] + freeGaps[i]);
            maxGapToLeft = Math.max(maxGapToLeft, freeGaps[i - 1]);
        }

        return maxFreeTime;
    }
}
