class Solution {
    public boolean closeStrings(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int[] a = new int[26];
        int[] b = new int[26];
        if(w1 !=w2){
            return false;
        }
        for(char i :word1.toCharArray()){
            a[i-'a']++;
        }
        for(char i :word2.toCharArray()){
            b[i-'a']++;
        }
        for(int i = 0;i<a.length;i++){
            if((a[i]==0) !=(b[i]==0)){
                return false;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);

        
    }
}