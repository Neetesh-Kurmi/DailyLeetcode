class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int[] answer = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            int low = 0;
            int high = potions.length - 1;

            int first = potions.length;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    first = mid;
                    high = mid - 1;
                } 
                else {
                    low = mid + 1;
                }
            }

            answer[i] = potions.length - first;
        }

        return answer;
    }
}