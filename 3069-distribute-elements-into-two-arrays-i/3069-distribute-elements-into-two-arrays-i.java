class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int i=0;
        int j = 0;
        arr1[i] = nums[0];
        arr2[j] = nums[1];
        for(int k = 2;k<n;k++){
            if(arr1[i]>arr2[j]){
                i++;
            arr1[i]=nums[k];
            }
            else{
                arr2[++j]=nums[k];
            }
        }
        for(int x = 0;x<=j;x++){
            arr1[++i]=arr2[x];
        }
        return arr1;
        
        
    }
}