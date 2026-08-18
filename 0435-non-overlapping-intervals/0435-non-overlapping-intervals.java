class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int count = 0;
        int preIndex = Integer.MIN_VALUE;
        for(int[] interval:intervals){
            if(interval[0]>=preIndex){
                count++;
                preIndex = interval[1];

            }
        }
        return intervals.length-count;
        
    }
}