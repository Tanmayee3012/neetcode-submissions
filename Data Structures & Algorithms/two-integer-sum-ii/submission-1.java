class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int i = 0; 
        int j = numbers.length-1;
        while (i < j){
            int cur = numbers[i] + numbers[j];
            if(cur == target){
                return new int[]{i+1,j+1};
            } else if(cur < target){
                i++;
            } else j--;
        }
        return new int[]{};
    }
}
