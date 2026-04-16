class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList <>();

        for(int num : arr) res.add(num);

        Collections.sort(res , (a,b) ->{
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);

            if(distA == distB) return a-b;
            return distA - distB;
        });
        List<Integer> list = res.subList(0 , k);
        Collections.sort(list);
        return list;
    }
}