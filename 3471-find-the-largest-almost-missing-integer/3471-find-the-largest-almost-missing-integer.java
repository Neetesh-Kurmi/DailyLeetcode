class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == n
        // There is only one subarray: the entire array.
        if (k == n) {
            int ans = -1;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // Frequency of every number
        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }

        // Case 2: k == 1
        // Every element itself is a subarray.
        // Therefore, a number must occur exactly once.
        if (k == 1) {
            int ans = -1;

            for (int num = 0; num <= 50; num++) {
                if (freq[num] == 1) {
                    ans = num;
                }
            }

            return ans;
        }

        // Case 3: 1 < k < n
        // Only the first and last elements can belong
        // to exactly one subarray of length k.

        int ans = -1;

        if (freq[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (freq[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}