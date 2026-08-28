class Solution {
    public int pivotIndex(int[] nums) {
        // for(int i = 0;i<nums.length;i++){
        //     int leftSum = 0 , rightSum = 0 ;
        //     for(int j = 0 ; j<i;j++){
        //         leftSum += nums[j];
        //     }
        //     for(int j = i+1;j<nums.length;j++){
        //         rightSum+=nums[j];
        //     }
        //     if(leftSum==rightSum) return i;
        // }
        // return -1;
        for(int i = 1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        for(int i =0;i<nums.length;i++){
            
            int preSum = 0;
            if(i>0) {
                preSum = nums[i-1];

            } 
            int postSum = 0;
            
            if(nums.length>i){
                postSum = nums[nums.length-1]-nums[i];
            }

            if(postSum==preSum) return i;

        }
        return -1;
        

        
    }
}