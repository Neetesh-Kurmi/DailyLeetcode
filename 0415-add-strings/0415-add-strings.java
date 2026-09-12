class Solution {
    public String addStrings(String num1, String num2) {
         int i = num1.length()-1;
         int j = num2.length()-1;
         int carry = 0;
         StringBuilder ans = new StringBuilder();
         while(i>=0||j>=0||carry !=0){
            int digit = 0;
            int digit1 = 0;
            if(i>=0){
                digit = num1.charAt(i)-'0';

            }
            if(j>=0){
                digit1 = num2.charAt(j)-'0';
            }
            int sum = digit+digit1+carry;
            ans.append(sum%10);
            carry=sum/10;
            i--;
            j--;

         }
         return ans.reverse().toString();

        
    }
}