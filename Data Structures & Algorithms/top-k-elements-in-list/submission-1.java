class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        Integer n = nums.length;
        List<Integer>[] freq = new List[n+1];
        for(int i=0;i < freq.length ; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index=0;
        for(int i = n ; i > 0 && index < k; i--){
            for(int j: freq[i]){
                res[index++] = j;
                if(index == k) return res;
            }
        }
        return res;
    }
}
