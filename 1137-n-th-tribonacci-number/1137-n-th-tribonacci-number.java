class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        else if(n==1 || n==2) return 1;
        else{
            int FTerm = 0;
            int STerm = 1;
            int TTerm = 1;
            for(int i = 0 ; i<n;i++){
                int FourthTerm =(FTerm + STerm +TTerm);
                FTerm = STerm;
                STerm = TTerm;
                TTerm = FourthTerm;
            }
            return FTerm;
        }
        
    }
}