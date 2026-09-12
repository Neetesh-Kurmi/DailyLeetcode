class Solution {
    public void reverseString(char[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            char temp = nums[low];
            nums[low]=nums[high];
            nums[high]=temp;
            low++;
            high--;
        }
        
    }
}