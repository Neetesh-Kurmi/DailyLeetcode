class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10 == 0 && x !=0)){
            return false;
        }
        int reverseHalf = 0;
        while(reverseHalf<x){
            reverseHalf = (reverseHalf*10) + (x%10);
            x= x/10;
        }
        if(x==reverseHalf || x== reverseHalf/10){
            return true;
        }
        return false;
        
    }
}