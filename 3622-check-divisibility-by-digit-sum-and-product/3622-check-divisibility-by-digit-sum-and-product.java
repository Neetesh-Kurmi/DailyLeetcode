class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int ml = 1;
        while(temp>0){
            int digit=temp%10;
            sum= sum+digit;
            ml = ml*digit;
            temp = temp/10;
        }
        return n%(sum+ml)==0;
        
        
    }
}