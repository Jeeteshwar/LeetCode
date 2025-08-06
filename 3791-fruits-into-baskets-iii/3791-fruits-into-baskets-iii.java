class Solution {
    void build(int i,int l,int r,int[] segmentTree,int[] baskets){
        if(l==r){
            segmentTree[i]=baskets[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*i+1,l,mid,segmentTree,baskets);
        build(2*i+2,mid+1,r,segmentTree,baskets);

        segmentTree[i]=Math.max(segmentTree[2*i+1],segmentTree[2*i+2]);
    }

    boolean checkUnplaced(int i,int l,int r,int[] segmentTree ,int fruit){
        if(segmentTree[i]<fruit) return false;
        if(l==r){
            segmentTree[i]=-1;
            return true;
        }
        int mid=(l+r)/2;
        boolean placed=false;
        if(segmentTree[2*i+1]>=fruit)
            placed= checkUnplaced(2*i+1,l,mid,segmentTree,fruit);
        else
            placed= checkUnplaced(2*i+2,mid+1,r,segmentTree,fruit);

        segmentTree[i]=Math.max(segmentTree[2*i+1],segmentTree[2*i+2]);
        return placed;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=baskets.length;
        int[] segmentTree=new int[4*n];
        
        build(0,0,n-1,segmentTree,baskets);
        int unplaced=0;
        for(int fruit : fruits){
            if(checkUnplaced(0,0,n-1,segmentTree,fruit)==false) unplaced++;
        }
        return unplaced;
    }
}