class Solution {
    public int[] sortEvenOdd(int[] nums) {

        int n = nums.length; // size of array
        PriorityQueue<Integer> odd = new PriorityQueue <>(Collections.reverseOrder());  //ODD -> max heap
        PriorityQueue<Integer> even = new PriorityQueue <>(); //EVEN -> min heap

        // loop to add odd indexes in odd heap && even indexes in even heap

        for(int i = 0 ; i < n ; i++){ 
            if(i % 2 != 0){ // logic to check even or odd
                odd.add(nums[i]); // if odd
            }
            else{
                even.add(nums[i]); // if even
            }
        }

        int arr[] = new int[n]; // new array to arrange the odd and even order

        for(int i = 0 ; i < n ; i+=2){ // this will add elements at even index , starts at 0 and goes alternative
                                        // 0 , 2 , 4 , 6 ......
            arr[i] = even.poll();
        }

        for(int i = 1 ; i < n ; i+=2){ // this will add elements at odd index , starts at 1 and goes alternative
                                        // 1 , 3 , 5 , 7 ......
            arr[i] = odd.poll();
        }

        return arr; // return the new built array


    }
    
}