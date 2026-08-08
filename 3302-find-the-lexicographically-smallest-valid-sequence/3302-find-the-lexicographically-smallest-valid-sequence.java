class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();


        int[] next = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            next[i] = next[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                next[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int k = 0;
        boolean used = false;

        for (int i = 0; i < n && k < m; i++) {

            if (word1.charAt(i) == word2.charAt(k)) {
                ans[k++] = i;
            }
            else if (!used && next[i + 1] >= m - k - 1) {
                ans[k++] = i;
                used = true;
            }
        }

        return k == m ? ans : new int[0];
    }
}