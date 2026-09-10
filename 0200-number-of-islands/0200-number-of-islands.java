class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        // Visit every cell in the grid.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // If we find unvisited land, it represents a new island.
                if (grid[r][c] == '1') {
                    islands++;

                    // Visit the complete connected island.
                    dfs(grid, r, c);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {

        // Stop if the cell is outside the grid or is already water.
        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == '0') {
            return;
        }

        // Mark the current land cell as visited.
        grid[r][c] = '0';

        // Explore all four possible directions.
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }
}
