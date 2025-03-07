class Solution {
    public int[] closestPrimes(int left, int right) {
        // Create boolean array for sieve
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        
        // 0 and 1 are not prime
        if (right >= 0) isPrime[0] = false;
        if (right >= 1) isPrime[1] = false;
        
        // Sieve of Eratosthenes
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Collect primes in the range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        // If less than 2 primes found, return [-1, -1]
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }
        
        // Find pair with minimum difference
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i-1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i-1);
                result[1] = primes.get(i);
            }
        }
        
        return result;
    }
}