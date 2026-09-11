class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 ||strs == null){
            return "";
        }
        Arrays.sort(strs);
        String left = strs[0];
        String right = strs[strs.length-1];
        int i = 0;
        while(i<right.length() && i<left.length() && left.charAt(i)==right.charAt(i)){
            i++;
        }
        return left.substring(0,i);
        
    }
}