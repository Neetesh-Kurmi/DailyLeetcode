class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance  = 0;
        for(char st:s.toCharArray()){
            if(st=='('){
                if(balance>0){
                    sb.append(st);
                }
                balance++;
            }
            else {
                    balance--;
                    if(balance>0){
                        sb.append(st);
                    }
                }

        }
    
    
        return sb.toString();
        
    }
}