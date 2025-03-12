class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0)
            count++;
        }
        int[] fact = new int [count];

        int idx = 0;

        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                fact[idx] = i;
                idx++;
            }
        
        }
        if(fact.length < k)
            return -1;
        

        System.out.println(fact[k-1]);
        return fact[k-1];
    }

}