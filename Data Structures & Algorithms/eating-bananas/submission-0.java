class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int mx = piles[0], n = piles.length;
        for(int i = 1; i < n; i++){
            if(mx < piles[i]) mx = piles[i];
        }
        int low = 1, high = mx, k = 0, minSpeed = 0;
        while(low <= high){
            k = (low + high) / 2;
            int currh = 0;
            for(int i = 0; i < n; i++){
                currh += Math.ceil((double) piles[i] / k);
            }
            if(currh <= h) {
                high = k - 1;
                minSpeed = k;
            }
            else if(currh > h) low = k + 1;
        }
        return minSpeed;
    }
}