class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount = 0;
        int currentCount = 0;
        for(int num:nums){
            if(num == 1){
                currentCount++;
                maxcount = Math.max(currentCount,maxcount);
            }
            else{
                currentCount = 0;
            }
        }
        return maxcount;
        
    }
}