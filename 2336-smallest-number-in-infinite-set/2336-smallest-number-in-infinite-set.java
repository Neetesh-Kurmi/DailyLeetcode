class SmallestInfiniteSet {

    private PriorityQueue<Integer> pq;
    private HashSet<Integer> set;
    private int next;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        next = 1;
    }

    public int popSmallest() {

        // If there is a number added back,
        // it is smaller than the untouched numbers.
        if (!pq.isEmpty()) {
            int num = pq.poll();
            set.remove(num);
            return num;
        }

        return next++;
    }

    public void addBack(int num) {

        // Only add if it was actually removed
        // and is not already present in heap.
        if (num < next && !set.contains(num)) {
            pq.add(num);
            set.add(num);
        }
    }
}