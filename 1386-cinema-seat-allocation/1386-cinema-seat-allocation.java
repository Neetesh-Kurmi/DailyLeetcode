import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        int ans = (n - map.size()) * 2;

        int leftMask   = (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4); // seats 2-5
        int middleMask = (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6); // seats 4-7
        int rightMask  = (1 << 5) | (1 << 6) | (1 << 7) | (1 << 8); // seats 6-9

        for (int mask : map.values()) {
            boolean left = (mask & leftMask) == 0;
            boolean middle = (mask & middleMask) == 0;
            boolean right = (mask & rightMask) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}