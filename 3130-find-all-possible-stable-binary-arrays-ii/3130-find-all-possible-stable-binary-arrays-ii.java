class Solution {
    int MOD = 1000000007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] arr = new int[ zero + 1 ][ one + 1 ][ 2 ];

        // here  i = zeroesLeft( # 0s ), j = onesLeft( # 1s )

        for( int i = 0; i <= Math.min( zero, limit ); i++ ) arr[i][0][0] = 1;

        for( int j = 0; j <= Math.min( one, limit ); j++ ) arr[0][j][1] = 1;

        for( int i = 0; i <= zero; i++ ) {
            for( int j = 0; j <= one; j++ ) {
                
                if( i == 0 || j == 0 ) continue;

                arr[i][j][1] = ( arr[i][j - 1][0] + arr[i][j - 1][1] ) % MOD;

                if( j - 1 >= limit ) {
                    arr[i][j][1] = ( arr[i][j][1] - arr[i][j - 1 - limit][0] + MOD ) % MOD;
                }

                arr[i][j][0] = ( arr[i - 1][j][0] + arr[i - 1][j][1]  ) % MOD;

                if( i - 1 >= limit ) {
                    arr[i][j][0] = ( arr[i][j][0] - arr[i - 1 - limit][j][1] + MOD ) %  MOD;
                }

            }
        }

        return ( arr[zero][one][0] + arr[zero][one][1] ) % MOD;

    }
}