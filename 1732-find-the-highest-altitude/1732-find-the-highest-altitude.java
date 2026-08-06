class Solution {
    public int largestAltitude(int[] gain) {
        int high = 0;
        int maxHigh = 0;
        for(int num :gain){
            high+=num;
            maxHigh = Math.max(maxHigh,high);
        }
        return maxHigh;
        
    }
}