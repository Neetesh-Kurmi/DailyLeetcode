class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        // Total number of flowers required.
        // m bouquets × k flowers per bouquet.
        long required = (long) m * k;

        // If there are not enough flowers in total,
        // it is impossible to make m bouquets.
        if (required > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        // Find the minimum and maximum blooming days.
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        int answer = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check whether we can make m bouquets
            // by day 'mid'.
            if (canMake(bloomDay, m, k, mid)) {

                // This day works.
                answer = mid;

                // Try to find an earlier valid day.
                right = mid - 1;

            } else {

                // This day is too early.
                // We need more days.
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                // This flower has bloomed by the given day.
                flowers++;

                // We have k consecutive bloomed flowers.
                if (flowers == k) {

                    // Make one bouquet.
                    bouquets++;

                    // These flowers are now used.
                    flowers = 0;

                    // We already have enough bouquets.
                    if (bouquets == m) {
                        return true;
                    }
                }

            } else {

                // This flower has not bloomed.
                // Therefore, the consecutive sequence breaks.
                flowers = 0;
            }
        }

        return false;
    }
}