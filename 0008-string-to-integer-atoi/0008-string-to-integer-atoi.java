class Solution {

    public int myAtoi(String s) {

        // Remove leading and trailing spaces
        s = s.trim();

        // If string becomes empty
        if (s.length() == 0)
            return 0;

        int index = 0;
        int sign = 1;
        int result = 0;

        // Check sign
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {

            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Read digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {

            int digit = s.charAt(index) - '0';

            // Check overflow before updating result
            if (result > Integer.MAX_VALUE / 10 ||
               (result == Integer.MAX_VALUE / 10 && digit > 7)) {

                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;

            index++;
        }

        return result * sign;
    }
}