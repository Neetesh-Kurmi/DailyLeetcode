class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int left = 0;
        int maxLength = 0;
        

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
            while(arr[ch-'a']>2){
                arr[s.charAt(left)-'a']--;
                left++;

            }
            maxLength =Math.max(maxLength,i-left+1);
        }
        return maxLength;
        
    }
}