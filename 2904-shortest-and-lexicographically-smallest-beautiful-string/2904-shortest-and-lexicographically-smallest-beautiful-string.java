class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int ones = 0;
        String ans = "";

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // Window has exactly k ones
            while (ones == k) {

                // Remove unnecessary leading zeroes
                while (left < right && s.charAt(left) == '0') {
                    left++;
                }

                String curr = s.substring(left, right + 1);

                // Update answer
                if (ans.equals("")
                        || curr.length() < ans.length()
                        || (curr.length() == ans.length()
                            && curr.compareTo(ans) < 0)) {
                    ans = curr;
                }

                // Move left past the current '1'
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }

        return ans;
    }
}