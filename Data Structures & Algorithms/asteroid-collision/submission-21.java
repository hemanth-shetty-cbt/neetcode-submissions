class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        int n = asteroids.length;

        for (int i=0; i<n;i++) {


            //1st condition 

            while (!st.isEmpty() && asteroids[i] < 0 &&st.peek() >0) {

                int diff = st.peek() + asteroids[i];

                if (diff < 0) {

                    //pop from the top

                    st.pop();
                
                } else if (diff > 0) {

                    asteroids[i] = 0;
                } else {

                    asteroids[i] = 0;
                    st.pop();
                }
            }


            if (asteroids[i] != 0) {
                st.push(asteroids[i]);
            }

        }

        int[] result = new int[st.size()];

        for (int i=st.size()-1; i>=0; i--) {
            result[i] = st.pop();
        }
        
        return result;
        
    }
}