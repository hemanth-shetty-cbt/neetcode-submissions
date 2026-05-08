class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        double cars[][] = new double[n][2];
        int fleet = 0;
        double prevTime = 0;

        for(int i=0; i<n; i++) {

            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i])/speed[i];
        
        }

        //sort based on position

        Arrays.sort(cars,(a,b) -> Double.compare(b[0], a[0]));

        for(int i=0; i<n; i++) {

            double current = cars[i][1];

            if(current > prevTime) {
                prevTime = current;
                fleet++;
            }
        }

        return fleet;
        
    }
}
