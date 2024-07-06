class Solution {
    public int passThePillow(int n, int time) {
        // Start with the first person
        int i = 1;

        // Continue the process until the given time is exhausted
        while(time > 0){
            // Pass the pillow to the right until the last person
            while(i < n && time > 0){
                i++;    // Move to the next person
                time--; // Decrease the remaining time
            }
            // Pass the pillow to the left until the first person
            while(i > 1 && time > 0){
                i--;    // Move to the previous person
                time--; // Decrease the remaining time
            }
        }

        // Return the person who has the pillow after the given time
        return i;
    }
}