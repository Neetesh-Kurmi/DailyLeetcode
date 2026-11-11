class Solution {
    public void rotate(int[] nums, int k) {
        
        int end=nums.length;
        k= k%end;
        if(nums.length<=1){
            return ;
        }
        reverse(nums,0,end-1);
        reverse(nums,k,end-1);
        reverse(nums,0,k-1);
        
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

}