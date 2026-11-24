class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort(Comparator.comparingInt(i -> i[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(list.get(0));

        for(int i = 1; i < list.size(); i++){
            int[] last = merged.get(merged.size() - 1);
            int[] curr = list.get(i);
            if(last[1] >= curr[0]){
                last[1] = Math.max(last[1], curr[1]);
            } else{
                merged.add(curr);
            }   
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
