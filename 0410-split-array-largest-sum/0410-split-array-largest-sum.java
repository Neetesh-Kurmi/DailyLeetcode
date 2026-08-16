class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // Minimum possible answer is the largest element
        // Maximum possible answer is the total sum
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        // Binary search for the minimum possible largest sum
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Count how many subarrays are needed
            // when maximum allowed sum is 'mid'
            int subarrays = 1;
            int currentSum = 0;

            for (int num : nums) {

                // If adding this element exceeds mid,
                // start a new subarray
                if (currentSum + num > mid) {
                    subarrays++;
                    currentSum = 0;
                }

                currentSum += num;
            }

            // If we can split into k or fewer subarrays,
            // try to find a smaller maximum sum
            if (subarrays <= k) {
                high = mid - 1;
            } else {
                // We need more subarrays,
                // so the maximum allowed sum is too small
                low = mid + 1;
            }
        }

        // Minimum valid maximum sum
        return low;
    }
}