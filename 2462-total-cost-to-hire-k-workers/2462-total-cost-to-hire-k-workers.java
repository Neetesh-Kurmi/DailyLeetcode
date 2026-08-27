class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;

        long total = 0;

        // Initially fill both heaps
        while (leftHeap.size() < candidates && left <= right) {
            leftHeap.add(costs[left]);
            left++;
        }

        while (rightHeap.size() < candidates && left <= right) {
            rightHeap.add(costs[right]);
            right--;
        }

        // Hire k workers
        for (int i = 0; i < k; i++) {

            int leftCost = leftHeap.isEmpty()
                    ? Integer.MAX_VALUE
                    : leftHeap.peek();

            int rightCost = rightHeap.isEmpty()
                    ? Integer.MAX_VALUE
                    : rightHeap.peek();

            // Choose cheaper side
            if (leftCost <= rightCost) {

                total += leftHeap.poll();

                // Add next worker from left
                if (left <= right) {
                    leftHeap.add(costs[left]);
                    left++;
                }

            } else {

                total += rightHeap.poll();

                // Add next worker from right
                if (left <= right) {
                    rightHeap.add(costs[right]);
                    right--;
                }
            }
        }

        return total;
    }
}