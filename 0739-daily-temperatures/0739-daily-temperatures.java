class Solution {
    public int[] dailyTemperatures(int[] tempratures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[tempratures.length];
        for(int i = 0;i<tempratures.length;i++){
            while(!stack.isEmpty() &&
             tempratures[i]>tempratures[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i-preIndex;
             }
             stack.push(i);
        }
        return ans;
        
    }
}