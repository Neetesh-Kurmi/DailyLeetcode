class Solution {
    public int totalNumbers(int[] digits) {

        // Stores only distinct valid 3-digit numbers.
        HashSet<Integer> set = new HashSet<>();

        int n = digits.length;

        // i = units digit
        for (int i = 0; i < n; i++) {

            // Last digit must be even.
            if (digits[i] % 2 != 0) {
                continue;
            }

            // j = tens digit
            for (int j = 0; j < n; j++) {

                // Cannot use the same array position twice.
                if (i == j) {
                    continue;
                }

                // k = hundreds digit
                for (int k = 0; k < n; k++) {

                    // Cannot reuse a position.
                    if (k == i || k == j) {
                        continue;
                    }

                    // A 3-digit number cannot start with 0.
                    if (digits[k] == 0) {
                        continue;
                    }

                    // Construct the number:
                    // hundreds * 100 + tens * 10 + units
                    int number = digits[k] * 100
                               + digits[j] * 10
                               + digits[i];

                    // HashSet removes duplicate numbers automatically.
                    set.add(number);
                }
            }
        }

        return set.size();
    }
}