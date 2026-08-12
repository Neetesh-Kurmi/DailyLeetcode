class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        int left = 0;
        int right = words.length-1;
        while(left<right){
            String temp = words[left];
            words[left]= words[right];
            words[right]=temp;
            left++;
            right--;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<words.length;i++){
            ans.append(words[i]);
            
            if(i!=words.length-1){
                ans.append(" ");

            }


        }
        return ans.toString();


        
    }
}