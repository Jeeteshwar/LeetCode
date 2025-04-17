class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> h1 =  new HashSet <>();
        HashSet<Integer> h2 =  new HashSet <>();

        for(int n1 : nums1) h1.add(n1);
        for(int n2 : nums2) h2.add(n2);

        for(int n : nums2){
            if(h1.contains(n)){
                h1.remove(n);
                h2.remove(n);
            }

        }
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList <>(h1));
        res.add(new ArrayList <>(h2));

        return res;
    }
}