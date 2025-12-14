class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        List<Integer> seats = new ArrayList<>();
        
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats.add(i);
            }
        }
        
        int m = seats.size();
        if (m == 0) return 0; // Actually problem says for 0 seats, 1 way? Let's check
        // Wait, given example "PPPP" → 1 way, so m=0 → return 1.
        // But in example "SSPPSPS" they gave 3 ways. Let me re-check prompt.
        // The example says: corridor = "SSPPSPS" → 3 ways.
        // For "PPPP" → 1 way (since no seats, no sections needed).
        // So m=0 → return 1.
        // But if m is odd and m>0 → return 0.
        
        if (m % 2 != 0) return 0;
        if (m == 0) return 1;
        
        long ans = 1;
        for (int i = 2; i < m; i += 2) {
            int gap = seats.get(i) - seats.get(i - 1);
            ans = (ans * gap) % MOD;
        }
        return (int) ans;
    }
}