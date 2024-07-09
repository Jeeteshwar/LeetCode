class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        double totalWaitTime = 0;

        int currTime = 0;
        for(int [] customer : customers ){
            int arrivalTime = customer[0];
            int cookingTime = customer[1];
            if(currTime < arrivalTime){
                currTime = arrivalTime;
            }
            int waitTime = currTime + cookingTime - arrivalTime;

            totalWaitTime = totalWaitTime + waitTime;

            currTime = currTime + cookingTime;

        }
         return totalWaitTime / n;
    }
}