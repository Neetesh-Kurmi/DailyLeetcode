class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy=0;
        for(int num :candies){
            maxCandy = Math.max(num,maxCandy);

        }
        ArrayList<Boolean> result = new ArrayList<>();
        for(int num :candies){
            result.add(num + extraCandies>=maxCandy);
                


            
        }
        return result;
        
    }
}