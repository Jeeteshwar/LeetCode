class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int totalDrunk = 0;
        int emptyBottles = 0;
        
        while (numBottles > 0) {
            // Drink all current full bottles
            totalDrunk += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;
            
            // Try to exchange empty bottles for new full bottles
            if (emptyBottles >= numExchange) {
                // Exchange as many times as possible
                int exchanged = 0;
                while (emptyBottles >= numExchange) {
                    emptyBottles -= numExchange;
                    numExchange++;
                    exchanged++;
                }
                numBottles = exchanged;
            }
        }
        
        return totalDrunk;
    }
}