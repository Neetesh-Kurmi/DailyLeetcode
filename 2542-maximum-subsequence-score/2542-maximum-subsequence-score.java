class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        // Store {nums2, nums1}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = nums1[i];
        }

        // Sort by nums2 in descending order
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            int n2 = arr[i][0];
            int n1 = arr[i][1];

            pq.add(n1);
            sum += n1;

            // Keep only k largest nums1 values
            if (pq.size() > k) {
                sum -= pq.poll();
            }

            // We have exactly k elements
            if (pq.size() == k) {
                answer = Math.max(answer, sum * n2);
            }
        }

        return answer;
    }
}