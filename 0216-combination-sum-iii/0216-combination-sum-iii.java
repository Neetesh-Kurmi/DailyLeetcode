class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int start,
        int k,
        int target,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Valid combination
        if (k == 0) {

            if (target == 0) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        // Target became invalid
        if (target <= 0) {
            return;
        }

        for (int num = start; num <= 9; num++) {

            // Choose
            current.add(num);

            // Explore
            backtrack(
                num + 1,
                k - 1,
                target - num,
                current,
                result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}