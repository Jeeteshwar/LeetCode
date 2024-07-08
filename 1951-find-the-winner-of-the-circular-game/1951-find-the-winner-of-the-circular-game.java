class Solution {
    public int findTheWinner(int n, int k) {
        // Initialize a queue to hold the players
        Queue<Integer> que = new LinkedList<>();

        // Add players numbered from 1 to n to the queue
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        // Continue the process until only one player remains in the queue
        while (que.size() > 1) {
            // Move the first k-1 players to the end of the queue
            for (int count = 1; count <= k - 1; count++) {
                que.add(que.poll());
            }
            // Remove the k-th player from the queue
            que.poll();
        }

        // The last remaining player is the winner
        return que.peek();
    }
}