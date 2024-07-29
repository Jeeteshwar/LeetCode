class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length; // Length of the input array
        int count = 0; // Initialize the count of valid teams

        // Iterate through each possible combination of indices i, j, k
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check if the sequence (rating[i], rating[j], rating[k]) is strictly increasing or decreasing
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) 
                        || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++; // Increment the count if a valid team is found
                    }
                }
            }
        }
        return count; // Return the total count of valid teams
    }
    }