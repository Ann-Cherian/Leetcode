class Solution {
    public boolean validMountainArray(int[] arr) {
        int i=0;
        //increasing
         while(i+1<arr.length && arr[i]<arr[i+1])
             i++;
        
        //peak can't be first or last
        if(i==0 || i==arr.length-1)
            return false;
        
        //decreasing
        while(i+1<arr.length && arr[i]>arr[i+1])
            i++;
        
        return i==arr.length-1;
        
    }
}