class Solution {
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(z - x);
        int d2 = Math.abs(z - y);

        if(d1 == d2){
            return 0;
        } 
        else if(d1 > d2){ // if x has less step return it
            return 2;
        }
        else{ //if y has less steps return it
            return 1;
        }
    }
}