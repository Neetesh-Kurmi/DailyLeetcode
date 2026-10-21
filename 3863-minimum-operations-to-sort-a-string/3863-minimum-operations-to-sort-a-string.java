
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        // Case 1: Already sorted
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        // Case 2: A reversed string of length 2 cannot be fixed
        if (n == 2) {
            return -1;
        }

        char min = 'z';
        char max = 'a';

        // Find the minimum and maximum characters
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);
        }

        // Case 3: One operation is enough
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Case 4: Minimum or maximum occurs in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // Case 5: Neither extreme is at an end or in the middle
        return 3;
    }
}
