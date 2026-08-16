class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit to the window
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // If there are more than 2 fruit types,
            // shrink the window from the left
            while (map.size() > 2) {

                int leftFruit = fruits[left];

                // Decrease frequency of the leftmost fruit
                map.put(leftFruit, map.get(leftFruit) - 1);

                // Remove it completely if its frequency becomes 0
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                left++;
            }

            // Current window contains at most 2 fruit types
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        
    }
}