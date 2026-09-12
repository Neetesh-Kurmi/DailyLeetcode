class Solution {
    public boolean isPowerOfTwo(int n) {
        //ternary operator
        return (n<=0) ? false :((n&(n-1))==0);


        //Bit Manipulation with & operator 
        // if(n<=0) return false;
        // return ((n&(n-1))==0) ;

        
        // recursion.......
        // if(n==1) return true;
        // if(n<=0 || n%2 !=0) return false;
        // return isPowerOfTwo(n/2);
        
    }
}