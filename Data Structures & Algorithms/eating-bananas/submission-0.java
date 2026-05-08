class Solution {
    public int minEatingSpeed(int[] piles, int h) {


     int left = 1, mid;

     int right = calMax(piles);

     while (left < right) {

        mid = left + (right -left )/ 2;

        if(canComplete(piles, mid, h)) {
            right = mid;
        } else {
            left = mid +1;
        }
     }

     return left;

        
    }

    public int calMax(int[] piles) {

        int max = 0;

        for(int i: piles) {
            max = Math.max(max, i);
        }
    return max;
    }

    public boolean canComplete(int[] piles, int k, int h) {

        int total = 0;

        for(int i: piles) {

            total += (i + k - 1)/k;
        }

        return total <= h;
    }
}
