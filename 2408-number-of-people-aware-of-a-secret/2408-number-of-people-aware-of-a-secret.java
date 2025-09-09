class Solution {
    public int peopleAwareOfSecret(int totalDays, int startSharingDelay, int forgetAfterDays) {
        long[] peopleWithSecret = new long[totalDays + 1];
        peopleWithSecret[1] = 1;
        long newSharers = 0;
        long MOD = (long)1e9 + 7;

        for (int day = 2; day <= totalDays; day++) {
            if (day - startSharingDelay > 0)
                newSharers = (newSharers + peopleWithSecret[day - startSharingDelay] + MOD) % MOD;
            if (day - forgetAfterDays > 0)
                newSharers = (newSharers - peopleWithSecret[day - forgetAfterDays] + MOD) % MOD;
            peopleWithSecret[day] = newSharers;
        }

        long totalKnowing = 0;
        for (int day = totalDays - forgetAfterDays + 1; day <= totalDays; day++)
            totalKnowing = (totalKnowing + peopleWithSecret[day]) % MOD;

        return (int)totalKnowing;
    }
}
