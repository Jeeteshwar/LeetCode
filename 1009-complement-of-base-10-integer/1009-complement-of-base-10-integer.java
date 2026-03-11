class Solution {
    public int bitwiseComplement(int n) {
        int allOne = 1;
        while(allOne < n){
            allOne = allOne * 2 + 1;
        }
        return allOne - n;
    }
}