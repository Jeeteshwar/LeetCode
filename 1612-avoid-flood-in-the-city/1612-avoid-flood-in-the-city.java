class Solution {

    public int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        Arrays.fill(result, 1);
        TreeSet<Integer> dryDays = new TreeSet<Integer>();
        Map<Integer, Integer> lakeLastRainDay = new HashMap<Integer, Integer>();

        for (int day = 0; day < rains.length; ++day) {
            if (rains[day] == 0) {
                dryDays.add(day);
            } else {
                result[day] = -1;
                if (lakeLastRainDay.containsKey(rains[day])) {
                    Integer dryDay = dryDays.ceiling(lakeLastRainDay.get(rains[day]));
                    if (dryDay == null) {
                        return new int[0];
                    }
                    result[dryDay] = rains[day];
                    dryDays.remove(dryDay);
                }
                lakeLastRainDay.put(rains[day], day);
            }
        }
        return result;
    }
}
