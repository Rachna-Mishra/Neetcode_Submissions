class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxB = 0;
        int n = piles.length;
        for(int i = 0; i < n; i++){
            maxB = Math.max(maxB, piles[i]);
        }
       int left = 1;
       int right = maxB;
       int minRate = 0;
       while(left <= right ){
        int hours = 0;
            int mid = (left + right)/2;
            for(int j = 0; j < n; j++){
                hours += Math.ceil((double)piles[j]/mid) ;
            }
            if(hours > h){
                left = mid + 1;
            }else{
                right = mid - 1;
                minRate = mid;
            }
       }
        return minRate;
    }
}
