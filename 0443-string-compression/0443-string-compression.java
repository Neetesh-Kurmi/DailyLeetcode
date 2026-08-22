class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0;
        int readIndex = 0;
        while(readIndex<chars.length){
            char ch = chars[readIndex];
            int count = 0;
            while(readIndex<chars.length && chars[readIndex]==ch){
                count++;
                readIndex++;
            }
            chars[writeIndex]=ch;
            writeIndex++;
            if(count>1){
                
            String fr = String.valueOf(count);
            for(int i = 0;i<fr.length();i++){
                chars[writeIndex++]=fr.charAt(i);

            }
            }

        }
        return writeIndex;
        
    }
}