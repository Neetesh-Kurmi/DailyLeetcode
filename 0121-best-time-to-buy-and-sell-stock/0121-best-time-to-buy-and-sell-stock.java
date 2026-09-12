class Solution {
    public int maxProfit(int[] nums) {
        int maxProfit = 0;
        int minPrice = nums[0];
        for(int i = 0;i<nums.length;i++){
            maxProfit = Math.max(maxProfit,nums[i]-minPrice);
            minPrice = Math.min(minPrice,nums[i]);
            
        }
        return maxProfit;
        
        
    }
}