class Solution {
    int M = 1000000007;
    public int fact(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % M;
        }
        return (int) result;
    }
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public int numPrimeArrangements(int n) {
        int Prime = 0;
        
        for(int i = 2 ; i <= n ; i++){
            if(isPrime(i)) Prime++;
        }
        int NonPrime = n - Prime;
        long PCount = fact(Prime);
        long NPCount = fact(NonPrime);

        return (int) ((PCount * NPCount) % M);
    }
}