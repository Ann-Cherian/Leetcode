class Solution {
    public int[] replaceElements(int[] arr) {
        
        int mx=-1,a;
        for(int i=arr.length-1;i>=0;i--)
        {
           a =arr[i];
           arr[i] = mx;
            mx=Math.max(mx,a);
        }
        return arr;
    }
}