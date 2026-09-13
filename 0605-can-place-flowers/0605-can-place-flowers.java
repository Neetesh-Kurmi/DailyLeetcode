class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if(n==0){
            return true;
        }
        for(int i = 0;i<m;i++){
            if(flowerbed[i]==0){
                boolean left = (i==0)|| flowerbed[i-1]==0;
            boolean right = (i==flowerbed.length-1)||(flowerbed[i+1]==0);
            if(left&&right){
                flowerbed[i]=1;
                n--;
                if(n==0){
                    return true;
                }
            }
            }
            
        }
        return false;
        
    }
}