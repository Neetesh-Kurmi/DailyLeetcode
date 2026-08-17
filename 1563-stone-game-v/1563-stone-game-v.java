class Solution {

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // Prefix sum helps us calculate subarray sums in O(1)
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score Alice can get
        // from subarray l to r
        int[][] dp = new int[n][n];

        // Length of the current subarray
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                // Try every possible split
                for (int k = l; k < r; k++) {

                    // Sum of left part: l ... k
                    int leftSum = prefix[k + 1] - prefix[l];

                    // Sum of right part: k+1 ... r
                    int rightSum = prefix[r + 1] - prefix[k + 1];

                    int score;

                    if (leftSum < rightSum) {

                        // Left part survives
                        score = leftSum + dp[l][k];

                    } else if (rightSum < leftSum) {

                        // Right part survives
                        score = rightSum + dp[k + 1][r];

                    } else {

                        // Both sums are equal.
                        // Alice can choose either part.
                        score = leftSum
                                + Math.max(dp[l][k], dp[k + 1][r]);
                    }

                    // Take the best split
                    dp[l][r] = Math.max(dp[l][r], score);
                }
            }
        }

        return dp[0][n - 1];
    }
}