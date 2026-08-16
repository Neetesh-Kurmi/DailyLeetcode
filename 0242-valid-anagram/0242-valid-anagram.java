class Solution {
    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same length
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] count = new int[26];

        // Count characters from s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Remove characters according to t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Every frequency must become zero
        for (int frequency : count) {
            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }
}