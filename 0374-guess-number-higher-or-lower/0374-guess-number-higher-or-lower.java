public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } 
            else if (result < 0) {
                // mid is too high
                high = mid - 1;
            } 
            else {
                // mid is too low
                low = mid + 1;
            }
        }

        return -1;
    }
}