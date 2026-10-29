class Solution {
    public int shipWithinDays(int[] weights, int days) {


        int left = maxElement(weights);
        int right  = sumElements(weights);

        while (left < right) {

            int mid = left + (right - left) /2;

            //logic to find if it completes by total days

            if (canComplete(weights, mid, days)) {
                right = mid; 
            } else {
                left = mid + 1;
            }
            //
        }

        return left;

        
    }

    public boolean canComplete(int[] arr, int capacity, int days) {

        int currentLoad = 0,daysNeeded =1;

        for (int a: arr) {

            if (currentLoad + a > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }

            currentLoad += a;
        }

        return daysNeeded <= days;

    }

    public int sumElements(int[] arr) {

        int sum = 0;

        for (int i: arr) {
            sum += i;
        }
        return sum;
    }



    public int maxElement(int[] arr) {

        int max = 0;

        for (int a:arr) {
            max = Math.max(max, a);
        }

        return max;
    }
}