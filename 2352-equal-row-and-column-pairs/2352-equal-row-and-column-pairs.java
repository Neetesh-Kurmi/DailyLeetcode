class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<n;j++){
                sb.append(grid[i][j]).append(",");

            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);

        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            StringBuilder sb1 = new StringBuilder();
            for(int j = 0;j<n;j++){
                sb1.append(grid[j][i]).append(",");

            }
            ans+= map.getOrDefault(sb1.toString(), 0);
        }
        return ans;
        
    }
}