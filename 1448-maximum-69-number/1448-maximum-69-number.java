class Solution {
    public int[] intToArr(int num) {
    String s = String.valueOf(num);
    int n = s.length();
    int[] arr = new int[n];
    
    for (int i = n - 1; i >= 0; i--) {
        arr[i] = num % 10;
        num /= 10;
    }
    return arr;
}
public int arrToInt(int[] arr) {
    int num = 0;
    for (int i = 0; i < arr.length; i++) {
        num = num * 10 + arr[i];
    }
    return num;
}

    public int maximum69Number (int num) {
        int [] arr = intToArr(num);

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 6){
                arr[i] = 9;
                break;
            }
            
        }
        int temp = arrToInt(arr);
        return temp;
    }
}