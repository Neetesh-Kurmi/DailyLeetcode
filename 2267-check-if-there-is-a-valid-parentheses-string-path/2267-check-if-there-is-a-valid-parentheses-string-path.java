class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Check parity constraint - path length must allow zero balance
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        
        // Use Set-based BFS to track reachable balances at each cell
        boolean[][][] visited = new boolean[m][n][(m + n) + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        // Start from (0,0)
        if (grid[0][0] == '(') {
            queue.offer(new int[]{0, 0, 1});
        }
        
        int[] dirs = {0, 1, 0, -1, 0}; // Down and Right only
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], bal = curr[2];
            
            // Reached destination with balance 0
            if (r == m - 1 && c == n - 1 && bal == 0) return true;
            
            // Try all four directions (but only right/down are valid moves)
            for (int d = 0; d < 2; d++) { // Only down and right
                int nr = r + dirs[d];
                int nc = c + dirs[d + 1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newBal = bal + (grid[nr][nc] == '(' ? 1 : -1);
                    
                    // Must stay non-negative and within bounds
                    if (newBal >= 0 && newBal <= m + n) {
                        if (!visited[nr][nc][newBal]) {
                            visited[nr][nc][newBal] = true;
                            queue.offer(new int[]{nr, nc, newBal});
                        }
                    }
                }
            }
        }
        
        return false;
    }
}